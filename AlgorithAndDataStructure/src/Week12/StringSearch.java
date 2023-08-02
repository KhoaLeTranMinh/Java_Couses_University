package Week12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringSearch {

	public static void main(String[] args) {
		List<String> stringData = new ArrayList<String>();
		try {
			Path file = Paths.get("./src/Week12/testdata-stringsearch.txt");
			stringData = Files.readAllLines(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arrString = stringData.toArray(new String[0]);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string that you want to search: ");
		String patternString = scanner.nextLine();
		int found = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < arrString.length; i++) {
			int idx = bfSearch(arrString[i], patternString);

			if (idx != -1) {
				found++;
				int len = 0;
				len += (idx + patternString.length());
				System.out.println("Match at the index " + (idx + 1) + " at the line " + (i + 1));
				System.out.println(arrString[i]);
				System.out.printf(String.format("%%%ds\n\n", len), patternString);

			}
		}

		if (found == 0) {
			System.out.println("There is no such string pattern in the text body.");
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start));

	}

	private static int bfSearch(String txt, String pat) {
		int pt = 0; // pointer of text
		int pp = 0; // pointer of pattern
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else {
				pt = (pt - pp) + 1;
				pp = 0;
			}
		}
		if (pp == pat.length()) {
			return pt - pp;
		}
		return -1;
	}

}
