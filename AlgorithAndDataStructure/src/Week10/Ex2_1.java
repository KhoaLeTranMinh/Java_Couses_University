package Week10;

import java.util.Scanner;

public class Ex2_1 {

    static void move(int n, int x, int y) {
        if (n >= 2)
            move(n - 1, x, 6 - x - y);

        System.out.println("move disk " + "[" + n + "] from " + x + " to " + y);

        if (n >= 2)
            move(n - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Tower of Hanoi");
        System.out.print("The number of disc：");
        int n = stdIn.nextInt();
        move(n, 1, 3); // move n discs from 1 to 3
    }

}
