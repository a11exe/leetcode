package org.example.ya;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Yandex task
 */
public class Planning {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();
        String[] arr = str.split(" ");
        int tasksCount = Integer.parseInt(arr[0]);
        List<Task> tasks = new ArrayList<>();
        int consumersCount = Integer.parseInt(arr[1]);
        Consumer[] consumers = new Consumer[consumersCount];
        for (int i = 0; i < consumersCount; i++) {
            consumers[i] = new Consumer(i + 1);
        }
        int queuesCount = Integer.parseInt(arr[2]);
        List<Queue> queues = new ArrayList<>();
        for (int i = 0; i < queuesCount; i++) {
            queues.add(new Queue(i+1));
        }
        for (int i = 0; i < tasksCount; i++) {
            String taskStr = reader.readLine();
            String[] taskArr = taskStr.split(" ");
            tasks.add(new Task(
                    Integer.parseInt(taskArr[0]),
                    Integer.parseInt(taskArr[1]),
                    Integer.parseInt(taskArr[2]),
                    i + 1));
        }
        Task [] result = new Task[tasksCount];
        int second = 1;
        while (isNotAllTasksInWork(tasks, queues)) {
            // System.out.println("=============================");
            List<Task> actualTasks = findActualTasks(second, tasks);
            // System.out.println("Second: " + second + " Tasks: " + actualTasks);
            for (Task task: actualTasks) {
                Queue queue = queues.get(task.queue - 1);
                List<Task> queueTasks = queue.getTasks();
                queueTasks.add(task);
            }
            for (int i = 0; i < queuesCount; i++) {
                // System.out.println("Queue num " + i + " " + queues.get(i));
            }
            consumersMakingTasks(consumers);
            List<Consumer> freeConsumers = findFreeConsumers(consumers);
            for (Consumer consumer: freeConsumers) {
               getTask(queues, consumer, second, result);
            }
            second++;
        }

        for (int i = 0; i < result.length; i++) {
            writer.write(String.valueOf(result[i].numConsumer));
            writer.write(" ");
            writer.write(String.valueOf(result[i].second));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void getTask(List<Queue> queues, Consumer consumer, int second, Task[] result) {
        List<Queue> sortedQueues = queues.stream()
                .sorted((q1, q2) -> {
                    if (q1.takenTasks - q2.takenTasks == 0) {
                        return q1.number - q2.number;
                    } else {
                       return q1.takenTasks - q2.takenTasks;
                    }
                })
                .collect(Collectors.toList());
        for (int i = 0; i < sortedQueues.size(); i++) {
            Queue queue = sortedQueues.get(i);
            List<Task> queueTasks = queue.getTasks();
            if (!queueTasks.isEmpty()) {
                Task actualTask = queueTasks.get(0);
                consumer.leftTime = actualTask.time;
                actualTask.numConsumer = consumer.getNumber();
                actualTask.second = second;
                // System.out.println("Consumer " + consumer.getNumber() + " get task " + actualTask.number + " on second " + second);
                result[actualTask.number-1] = actualTask;
                queue.takenTasks++;
                queueTasks.remove(0);
                break;
            }
        }
    }

    private static boolean isNotAllTasksInWork(List<Task> tasks, List<Queue> queues) {
        boolean allTaskInQueues = false;
        if (tasks.size() == 0) {
            allTaskInQueues = true;
        }
        if (allTaskInQueues) {
            for (int i = 0; i < queues.size(); i++) {
                if (!queues.get(i).tasks.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static void consumersMakingTasks(Consumer[] consumers) {
        for (int i = 0; i < consumers.length; i++) {
            Consumer consumer = consumers[i];
            consumer.makeTask();
        }
    }

    private static List<Consumer> findFreeConsumers(Consumer[] consumers) {
        List<Consumer> freeConsumers = new ArrayList<>();
        for (int i = 0; i < consumers.length; i++) {
            Consumer consumer = consumers[i];
            if (consumer.getLeftTime() == 0) {
                freeConsumers.add(consumer);
            }
        }
        return freeConsumers;
    }

    private static List<Task> findActualTasks(int second, List<Task> tasks) {
        List<Task> actualTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (second == tasks.get(i).start) {
                actualTasks.add(tasks.get(i));
            }
        }
        tasks.removeAll(actualTasks);
        return actualTasks;
    }

    public static class Task {
        int start;
        int queue;
        int time;
        int number;
        int numConsumer;
        int second;

        public Task(int start, int queue, int time, int number) {
            this.start = start;
            this.queue = queue;
            this.time = time;
            this.number = number;
        }

        public int getNumConsumer() {
            return numConsumer;
        }

        public void setNumConsumer(int numConsumer) {
            this.numConsumer = numConsumer;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public int getNumber() {
            return number;
        }

        public int getStart() {
            return start;
        }

        public int getQueue() {
            return queue;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", queue=" + queue +
                    ", time=" + time +
                    ", number=" + number +
                    ", numConsumer=" + numConsumer +
                    ", second=" + second +
                    '}';
        }
    }

    public static class Consumer {
        int number;
        int leftTime;

        public Consumer(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public int getLeftTime() {
            return leftTime;
        }

        public void setLeftTime(int leftTime) {
            this.leftTime = leftTime;
        }

        public void makeTask() {
            if (leftTime > 0) {
                leftTime = leftTime - 1;
            }
            // System.out.println("Consumer " + getNumber() + " left time " + leftTime);
        }
    }

    public static class Queue {
        int number;
        int takenTasks;

        public Queue(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getTakenTasks() {
            return takenTasks;
        }

        public void setTakenTasks(int takenTasks) {
            this.takenTasks = takenTasks;
        }

        List<Task> tasks = new ArrayList<>();

        public List<Task> getTasks() {
            return tasks;
        }

        @Override
        public String toString() {
            return "Queue{" +
                    "number=" + number +
                    ", takenTasks=" + takenTasks +
                    ", tasks=" + tasks +
                    '}';
        }
    }
}
