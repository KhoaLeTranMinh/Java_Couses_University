package Week5;



import java.util.*;

public class Comb_Sort {

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
	
	public static void combSort (int[]array ,int size) {
		int gap = size;
		double shrink = 1.3;
		boolean sorted = false;
		
		while (sorted == false) {
			gap = gap * 10 / 13;
			if (gap <= 1) {
				gap = 1;
				sorted = true;
			}
			int i = 0;
			while (i+gap < size) {
				if (array[i] > array[i+gap]) {
					swap(array,i,i+gap);
					sorted = false;
					print(array,size);
				}
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size]; 
		for (int i = 0 ; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		combSort(arr,size);
	}

}
