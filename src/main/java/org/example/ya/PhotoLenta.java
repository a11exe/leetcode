package org.example.ya;

import java.io.*;
import java.util.Arrays;

/**
 * Yandex task
 */
public class PhotoLenta {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int expectedWeight = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        String[] arr = str.split(" ");
        int count = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int[] photosHeights = new int[count];
        for (int i = 0; i < count; i++) {
            String photoStr = reader.readLine();
            String[] photoArr = photoStr.split("x");
            int w = Integer.parseInt(photoArr[0]);
            int h = Integer.parseInt(photoArr[1]);
            if (w != expectedWeight) {
                photosHeights[i] = calculateHeight(w, h, expectedWeight);
            } else {
                photosHeights[i] = h;
            }
        }
        Arrays.sort(photosHeights);
        int minHeight = 0;
        for (int i = 0; i < k; i++) {
            minHeight = minHeight + photosHeights[i];
        }
        int maxHeight = 0;
        for (int i = 0; i < k; i++) {
            maxHeight = maxHeight + photosHeights[photosHeights.length - 1 - i];
        }
        writer.write(String.valueOf(minHeight));
        writer.newLine();
        writer.write(String.valueOf(maxHeight));

        reader.close();
        writer.close();
    }

    public static int calculateHeight(int w, int h, int expectedWeight) {
        int rez = ( h * expectedWeight) / w;
        int rest = ( h * expectedWeight) % w;
        if (rest != 0) {
            rez++;
        }
        return rez;
    }

}
