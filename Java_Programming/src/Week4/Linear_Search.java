package Week4;

import java.util.Scanner;

public class Linear_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[]array = new int[num];
		for (int i = 0; i< num; i++) {
			array[i]= scan.nextInt();
		}
		int k = scan.nextInt();
		
		for(int i = 0; i< num; i++) {
			if (array[i] < k) {
				System.out.printf("%d %d\n",i,array[i]);
			}else if(array[i] == k){
				System.out.printf("%d %d\n",i,array[i]);
				break;
			}else {
				break;
			}
		}
	}
		
}
