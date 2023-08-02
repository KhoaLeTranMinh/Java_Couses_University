package Week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// define an array to be sorted
		int[] arr = null;
		try {
			// System.out.println(System.getProperty("user.dir")); // return the current
			// directory
			Path file = Paths.get("./src/Week12/testdata-sort-4.txt");
			List<String> stringData = Files.readAllLines(file);
			arr = new int[stringData.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(stringData.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// execute quick sort
		System.out.println("Quick Sort: ");
		long start = System.currentTimeMillis();
		quickSort(arr, 0, arr.length - 1);
		long end = System.currentTimeMillis();
		// show the result
		for (int i = 0; i < arr.length; i++)
			 System.out.println("arr[" + i + "]=" + arr[i]);
//			System.out.print(arr[i] + " ");

		System.out.println("Execution time: " + (end - start));
	}

	public static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = a[(pl + pr) / 2];
		do {
			while (a[pl] < pivot)
				// We move left pointer until tbe value it points to is larger than pivot
				pl += 1;
			while (a[pr] > pivot)
				// We move right pointer until tbe value it points to is smaller than pivot
				pr -= 1;

			if (pl <= pr) {
				swap(a, pl, pr); // By doing this, the values larger than pivot will mmove to the right and the
									// smaller ones will be moved to the left
				pl += 1;
				pr -= 1;
			}
		} while (pl <= pr);

		if (left < pr) {
			quickSort(a, left, pr);
		}
		if (pl < right) {
			quickSort(a, pl, right);
		}
	}

}
