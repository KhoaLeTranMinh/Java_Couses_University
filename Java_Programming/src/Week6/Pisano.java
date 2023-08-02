package Week6;

import java.util.Scanner;

public class Pisano {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int i = scan.nextInt();
		System.out.println(calculate(n,m,i));
	}
		
	public static int calculate (int n, int m, int i) {
		int[]countRepeat = new int[m];
		countRepeat[0] = 1;
		countRepeat[1] = 1;
		int prev = 0;
		int curr = 1;
		int count = 0;
		int result = 0;
		
		while(count< n) {
			int temp = curr;
			curr = (int) ((prev+curr) % m);
			prev = temp;
			count++;
			countRepeat[curr]++;
		}
		
		int accumulate = 0;
		int countUp = 0;
		while (true) {
			accumulate += countRepeat[countUp];
			if (accumulate >= i) {
				result = countUp;
				break;
			}
			countUp++;
		}
		return result;
	}
	
}

