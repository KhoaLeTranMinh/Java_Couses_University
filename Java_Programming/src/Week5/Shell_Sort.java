package Week5;

import java.util.*;

public class Shell_Sort {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void print(int[] a, int size) {
		for (int i = 0; i < size; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}

	public static int calculateInterval(int size) {
		double sizeCopy = size;
		int ceilingUp = (int) Math.ceil(sizeCopy/3);
		double expression1 = (ceilingUp * 2)+1;
		int k = (int) Math.floor((Math.log10(expression1))/(Math.log10(3)));
		int h = (int) (((Math.pow(3, k))-1)/2);
		return h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean hasSwap;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		Shell_sort(n, arr);
	}

	public static void Shell_sort(int n, int[] arr) {
		
		int ini = calculateInterval(n);
		boolean hasSwap = false;
		for(int gap = ini; gap > 0; gap/=3){
			if (gap < 1) {
				gap = 1;            
			}
			for (int i = 0; i + gap < n; i++) {
				hasSwap = false;
				int keyNum = i + gap;
				int key = arr[keyNum];
				int j = keyNum - gap;
				while (j >= 0 && key < arr[j]) {
					hasSwap = true;
					swap(arr, keyNum, j);
					keyNum-=gap;
					j-= gap;
				}
				if (hasSwap) {
					print(arr, n);
				}
			}
		}
	}

}
