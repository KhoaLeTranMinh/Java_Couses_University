package Week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = null;
		try {
			Path file = Paths.get("./src/Week12/testdata-search.txt");
			List<String> stringData = Files.readAllLines(file);
			arr = new int[stringData.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(stringData.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Enter the key to search: ");
		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();
		// execute sequential search
		int index = binarySearch(arr, 0, arr.length - 1, key);
		// show the result
		if (index == -1)
			System.out.println("Not found");
		else
			System.out.println("Found in array[" + index + "]");
	}

	static int binarySearch(int[] arr, int pl, int pr, int key) {
		if (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (arr[pc] < key) {
				return binarySearch(arr, pc + 1, pr, key);
			} else if (arr[pc] > key) {
				return binarySearch(arr, pl, pc - 1, key);
			} else {
				return pc;
			}
		}
		return -1;
	}

}
