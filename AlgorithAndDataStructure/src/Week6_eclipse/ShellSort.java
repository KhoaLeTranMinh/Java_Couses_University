package Week6_eclipse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ShellSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = null;
        try {
            // System.out.println(System.getProperty("user.dir")); // return the current
            // directory
            Path file = Paths.get("./src/Week6/testdata-sort-2.txt");
            List<String> stringData = Files.readAllLines(file);
            arr = new int[stringData.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(stringData.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The number of elements: " + arr.length);
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("x[" + i + "]=" + arr[i]);
        }
        System.out.println("Execution time: " + (end - start));
    }

    public static void selectSort(int[] arr) {
        int size = arr.length;
        for (int k = size / 2; k >= 1; k /= 2) {

            for (int i = k; i < size; i += k) {
                int temp = arr[i];
                int j = i - k;
                for (; (j >= 0) && (arr[j] > temp); j -= k) {
                    arr[j + k] = arr[j];
                }
                arr[j + k] = temp;
            }

            k /= 2;
        }

    }

}
