package Week4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {

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
		selectSort(arr);
		long end = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			System.out.println("x[" + i + "]=" + arr[i]);
		}
		System.out.println("Execution time: " + (end - start));
	}

	public static void selectSort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}