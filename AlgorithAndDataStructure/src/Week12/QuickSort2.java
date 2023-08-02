package Week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class QuickSort2 {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("x[" + i + "]: " + a[i]);
        }
    }

    public static int[] readFile(String filename) {
        // method to read the file
        int[] arr = { 0 };
        try {
            Path file = Paths.get(filename);
            List<String> stringData = Files.readAllLines(file);
            int[] array = new int[stringData.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(stringData.get(i));
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        return arr;
    }

    static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, right);
        return i + 1;
    }

    static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
    }

    public static void quickSort2(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) {
                pl++;
            }

            while (a[pr] > x) {
                pr--;
            }

            if (pl <= pr) {
                swap(a, pl, pr);
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort2(a, left, pr);
        }

        if (pl < right) {
            quickSort2(a, pl, right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter filename: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        String filepath = "./src/Week12/" + filename + ".txt";

        int[] x = readFile(filepath);

        // Execute quick sort
        System.out.println("Quick Sort");
        long start = System.currentTimeMillis();
        quickSort2(x, 0, x.length - 1);
        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + " ms");
        // printArray(x);
    }
}