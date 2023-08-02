package Week4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = null;
		try {
			// System.out.println(System.getProperty("user.dir")); // return the current
			// directory
			Path file = Paths.get("./src/Week4/testdata-sort-4.txt");
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
		insertSort(arr);
		long end = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			System.out.println("x[" + i + "]=" + arr[i]);
		}
		System.out.println("Execution time: " + (end - start));
	}

	public static void insertSort(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			int temp = arr[i];
			int j = i - 1;
			for (; (j >= 0) && (arr[j] > temp); j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}

}
