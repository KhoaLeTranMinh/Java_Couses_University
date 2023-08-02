package Week7;
import java.util.Scanner;

public class Main {
    public static char[][] rotate(char a[][], int n)
    {
        int i, j;
        for(i=100; i<n+100; i++)  
        {  
            for(j=i; j<n+100; j++)  
            {  
                if(i!=j)  
                {  
                    char temp = a[i][j];  
                    a[i][j]=a[j][i];  
                    a[j][i]=temp;  
                }  
            }  
        }  
        for(i=100;i<100+n;i++)  
        {  
            int left = 100, right = 100 + n-1;  
            while(left < right)  
            {  
                char temp = a[i][left];  
                a[i][left] = a[i][right];  
                a[i][right] = temp;  
                left++;  
                right--;  
            }  
        }  
        return a;
    }
 
 
    public static char[][] shift(char a[][], int x, int y, int n)
    {
        char[][] r = new char[300][300];
        int i, j;
        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                if(a[i+100][j+100]=='#')
                {
                    r[i+100+y][j+x+100] = '#';
                }
                else
                {
                    r[i+y+100][j+x+100]='.';
                }
            }
        }
        for(i=100; i<100+n; i++)
        {
            for(j=100; j<100+n; j++)
            {
                a[i][j]=r[i][j];
            }
        }
        return a;
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, j;
        char a[][] = new char[300][300];
        for(i = 0; i<n; i++)
        {
            String row = sc.next();
            for(j = 0; j<n; j++)
            {
            a[i+100][j+100] = row.charAt(j);
            }
        }
       
        while(true) {
            String command = sc.next();
            if (command.equals("end"))
            {
                break;
            }
            else if (command.equals("dot")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                a[y+100][x+100] = '#';
            }
            else if (command.equals("shift"))
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                a = shift(a, x, y, n);
            }
            else if (command.equals("rotate")) 
            {
                a = rotate(a,n);
            }
        }
 
        for(i = 100; i < n+100; i++)
        {
            for(j = 100; j < n+100; j++)
            {
                if(a[i][j]==35)
                {
                    System.out.printf("#");
                }
                else
                {
                    System.out.printf(".");
                }
            }
            System.out.printf("\n");
        }
    }
}