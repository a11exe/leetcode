package org.example.ya;

import java.io.*;

/**
 * Yandex task
 */
public class Matrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());
        int size = num * 2 + 1;
        int[][] matrix = new int[size][size];
        int zeroPosition = 0;
        int positive = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // System.out.println("i, j "+i+" "+j);
                if (j == zeroPosition) {
                    // skip
                } else {
                    if (isOddPosition(i, j)) {
                        matrix[i][j] = positive++;
                    }
                }
            }
            zeroPosition++;
        }

        zeroPosition = 0;
        int negative = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // System.out.println("i, j "+i+" "+j);
                if (j == zeroPosition) {
                    // skip
                } else {
                    if (!isOddPosition(j, i)) {
                        matrix[j][i] = negative--;
                    }
                }
            }
            zeroPosition++;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                writer.write("" + String.valueOf(matrix[i][j])+ " ");
            }
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    public static boolean isOddPosition(int i, int j) {
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        if (i%2 != 0 && j%2 ==0) {
            return true;
        }
        if (i%2 == 0 && j%2 !=0) {
            return true;
        }
        return false;
    }
}
