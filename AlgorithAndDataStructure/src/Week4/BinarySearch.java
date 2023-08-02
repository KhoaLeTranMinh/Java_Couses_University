package Week4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = null;
		try {
//			System.out.println(System.getProperty("user.dir")); // return the current directory 
			Path file = Paths.get("./src/Week4/testdata-search.txt");
			List<String> stringData = Files.readAllLines(file);
			arr = new int[stringData.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(stringData.get(i));
			}
//			for (int num : arr) {
//				System.out.print(" " + num);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("Key: ");
		int key = scan.nextInt();
		long start = System.currentTimeMillis();
		int result = binarySearch(arr, key);
		long end = System.currentTimeMillis();
		if (result == -1) {
			System.out.println("Key is not found in the array!");
		} else {
			System.out.println("Found in array[" + result + "]");
		}
//		System.out.println("Execution time: " + (end - start));
	}

	public static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (true) {
			int mid = (left + right) / 2;
			if (left > right) {
				break;
			}
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				right = mid - 1;
				continue;
			}
			if (arr[mid] < key) {
				left = mid + 1;
				continue;
			}
		}

		return -1;
	}

}
