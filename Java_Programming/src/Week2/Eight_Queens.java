package Week2;

import java.util.*;

public class Eight_Queens {

	static char[][] board = new char[8][8];
	static Set<Integer> positive = new HashSet<Integer>();
	static Set<Integer> negative = new HashSet<Integer>();
	static Set<Integer> columns = new HashSet<Integer>();
	static Set<Integer> rows = new HashSet<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] pieces_row = new int[num];
		int[] pieces_col = new int[num];
		for (int i = 0; i < num; i++) {
			pieces_row[i] = scan.nextInt();
			pieces_col[i] = scan.nextInt();
			columns.add(pieces_col[i]);
			rows.add(pieces_row[i]);
			positive.add(pieces_row[i]+pieces_col[i]);
			negative.add(pieces_row[i]- pieces_col[i]);
		}
		initialize(num, pieces_row, pieces_col);
		backtrack(0);
		printBoard();

	}

	public static void initialize(int num, int[] pieces_row, int[] pieces_col) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < num; k++) {
					if (pieces_row[k] == i && pieces_col[k] == j) {
						board[i][j] = 'Q';
						break;
					}
				}
				if (board[i][j] == 'Q') {
					continue;
				} else {
					board[i][j] = '.';
				}
			}
		}
	}

	public static void printBoard() {
		for(int i = 0; i< 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%c", board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void backtrack(int row) {
		if (rows.size()==8) {
			return;
		}
		if (rows.contains(row)) {
			backtrack(row+1);
		}
		for(int col = 0; col< 8; col++) {
			if(columns.contains(col) || positive.contains(row+col)|| negative.contains(row-col) || rows.contains(row)) {
				continue;
			}else {
				columns.add(col);
				positive.add(row+col);
				negative.add(row-col);
				rows.add(row);
				board[row][col]='Q';
				
				
				backtrack(row+1);
				
				
				if (rows.size()==8) { //This line is super important!!
					return;
				}
				
				columns.remove(col);
				positive.remove(row+col);
				negative.remove(row-col);
				rows.remove(row);
				board[row][col]='.';
			}
		}
	}

}
