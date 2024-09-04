import java.util.*;
import java.io.*;

public class LeftSameNumberTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.print(i+1);
            }
            System.out.println();
        }
        sc.close();
    }
}
/*
 * }
5
1
22
333
4444
55555
 */