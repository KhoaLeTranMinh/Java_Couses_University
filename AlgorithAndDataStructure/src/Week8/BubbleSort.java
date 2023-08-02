package Week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = null;
        try {
            // System.out.println(System.getProperty("user.dir")); // return the current
            // directory
            Path file = Paths.get("./src/Week8/testdata-sort-2.txt");
            List<String> stringData = Files.readAllLines(file);
            arr = new int[stringData.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(stringData.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] arrCopy1 = new int[arr.length];
        int[] arrCopy2 = new int[arr.length];
        arrCopy1 = Arrays.copyOf(arr, arr.length);
        arrCopy2 = Arrays.copyOf(arr, arr.length);

        System.out.println("The number of elements: " + arr.length);

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Execution time for the original bubble sort: " + (end - start));

        long start1 = System.currentTimeMillis();
        bubbleSort1(arrCopy1);
        long end1 = System.currentTimeMillis();
        System.out.println("Execution time for first variant: " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        bubbleSort2(arrCopy2);
        long end2 = System.currentTimeMillis();
        System.out.println("Execution time for second variant: " + (end2 - start2));

        // System.out.println("Array result for original bubble sort: ");
        // printOutElements(arr);
        // System.out.println("Array result for first variant: ");
        // printOutElements(arrCopy1);
        // System.out.println("Array result for second variant: ");
        // printOutElements(arrCopy2);
    }

    private static void printOutElements(int[] arrCopy) {
        for (int i = 0; i < arrCopy.length; i++) {
            System.out.print(arrCopy[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = n - 1; j >= i + 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

    }

    public static void bubbleSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int exchange = 0;
            for (int j = n - 1; j >= i + 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    exchange++;
                }
            }
            if (exchange == 0) {
                return;
            }
        }

    }

    public static void bubbleSort2(int[] arr) {
        int n = arr.length;
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j >= k + 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }

    }

}
