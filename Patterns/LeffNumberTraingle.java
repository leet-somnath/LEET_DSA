import java.util.*;
import java.io.*;

public class LeffNumberTraingle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=i+1;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
        sc.close();
    }
}
/*
 * 5
1
12
123
1234
12345
 */