package Week6;



import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int arr[] = new int[num];
		for (int i = 0; i< arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		Quicksort(arr, 0, num-1, num);
	}
	public static void swap (int arr[], int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	public static void print (int arr[]) {
		for (int i = 0; i< arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	public static int pivotFinder(int[] arr, int lowIdx, int highIdx) {
		int center = (lowIdx+highIdx)/2;
		int[]candidate = new int[]{arr[lowIdx],arr[center],arr[highIdx]};
		Arrays.sort(candidate);
		int pivotIdx = 0;
		int pivot = 0;
		for (int i = 0;i<arr.length; i++) {
			if (arr[i] == candidate[1]) {
				pivotIdx = i;
				pivot = arr[pivotIdx];
			}
		}
		return pivot;
	}
	
	public static void Quicksort(int arr[], int lowIdx, int highIdx, int num) {
		if (lowIdx >= highIdx) {
			return;
		}
		int[] newPivotIdx = Partition(arr, lowIdx, highIdx);
		Quicksort(arr, lowIdx, newPivotIdx[0]-1,num);	
		Quicksort(arr,newPivotIdx[1]+1,highIdx,num);					
	}
	
	
	public static int[] Partition(int arr[], int lowIdx, int highIdx) {
		int pivot = pivotFinder(arr, lowIdx, highIdx);
		int leftPointer = lowIdx;
		int rightPointer = highIdx;
		while (true) {
			while ( arr[leftPointer] < pivot ) {
				leftPointer++;
			}
			
			while ( arr[rightPointer] > pivot ) {
				rightPointer--;
			}
			if (leftPointer < rightPointer) {
				swap(arr, leftPointer, rightPointer);	
				leftPointer++;
				rightPointer--;
			}else if(leftPointer >= rightPointer) {
				print(arr);
				break;
			}
		}
		int[] leftRight = new int[2]; 
		leftRight[0] = leftPointer;
		leftRight[1] = rightPointer;
		return leftRight;
	}

}
