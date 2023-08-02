package Week3;

import java.util.*;
public class PrintBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (true) {
			int height = scan.nextInt();
			int width = scan.nextInt();
			if (width == 0 && height == 0) {
				break;
			}
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (i % 2 == 0 && j % 2 == 0) {
						System.out.printf("#");
						continue;
					}
					if (i % 2 == 0 && j % 2 != 0) {
						System.out.printf(".");
						continue;
					}
					if (i % 2 != 0 && j % 2 == 0) {
						System.out.printf(".");
						continue;
					}
					if (i % 2 != 0 && j % 2 != 0) {
						System.out.printf("#");
						continue;
					}
				}
				System.out.println();
			} 
		}
	}

}

