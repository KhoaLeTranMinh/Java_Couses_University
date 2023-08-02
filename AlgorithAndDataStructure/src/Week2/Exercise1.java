package Week2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		int[] arr = null;
		try {
//			System.out.println(System.getProperty("user.dir")); // return the current directory 
			Path file = Paths.get("./src/Week2/test-data-100.txt");
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
		int num = arr.length;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Key: ");
		int key = scan.nextInt();
		

		int index = seqSearch(arr, num, key);

		if (index == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("Found in array[" + index + "]");
		}

	}
	
	public static int seqSearch(int a[], int length, int key) {
		int index = 0; 
		while (true) {
			if (index == length ) {
				return -1;
			}
			if (a[index] == key) {
				return index;
			}
			index++;
		}
	}
}
