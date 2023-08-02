
package Week_1;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(gcd(a,b));
	}

    public static int gcd(int n1, int n2) {
    if (n2 == 0) {
        return n1;
    }
    return gcd(n2, n1 % n2);
}

}
