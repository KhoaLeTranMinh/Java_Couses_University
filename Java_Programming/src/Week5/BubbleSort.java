package Week5;



import java.util.*;

public class BubbleSort {

	public static void swap(int[] a, int i, int j){
		int temp = a[i];
	  	a[i] = a[j];
	  	a[j] = temp;
	}
	public static void print(int[]a, int size) {
		for (int i = 0 ; i < size; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n]; 
		for (int i = 0 ; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 0 ; i < n - 1; i++) {
			for (int j = 0 ; j < n - i - 1; j++ ) {
				if (arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
					print(arr,n);
				}
			}
		}
	}

}
