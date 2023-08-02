package Week10;

import java.util.Scanner;

public class Ex1_1_Test {
    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return (x);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("GCD of two integers");
        System.out.print("Input Integer：");
        int x = stdIn.nextInt();
        System.out.print("Input Integer：");
        int y = stdIn.nextInt();
        long start = System.currentTimeMillis();
        int gcd = gcd(x, y);
        long end = System.currentTimeMillis();
        System.out.println("GCD: " + gcd);
        System.out.println("Execution time: " + (end - start));
    }
}
