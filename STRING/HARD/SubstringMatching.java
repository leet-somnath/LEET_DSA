/*
 * You are given two strings A and B. You are also given Q queries with 4 indices
 *  i, j, k and l. Check whether the substring of A[i:j] matches the substring of B[k:l].

Input Format

First line of input contains T - number of test cases. In each test case, the first
line contains the string A and the second line contains the string B.
The next line contains an integer Q - the number of queries. The Q subsequent lines
 each contain 4 integers i, j, k and l, separated by a space.

Constraints

30 points
1 <= T <= 100
1 <= len(A), len(B) <= 100
0 <= Q <= 1000

70 points
1 <= T <= 100
1 <= len(A), len(B) <= 10000
0 <= Q <= 10000

General Constraints
'a' <= A[i], B[i] <= 'z'
0 <= i <= j < len(A)
0 <= k <= l < len(B)

Output Format

For each query, on a new line, print "Yes" if the substring of A matches the substring of B, print "No" otherwise.

Sample Input 0

2
smartinterviews
intermediate
2
5 9 0 4
1 3 2 4
hackerrank
hackerearth
1
0 3 0 3
Sample Output 0

Yes
No
Yes
Explanation 0

Test Case 1
The substring of "smartinterviews" from index 5 to 9 is "inter". The substring of "intermediate" from 0 to 4 is also "inter". Since they are equal, the output is "Yes".
The substring of "smartinterviews" from index 1 to 3 is "mar". The substring of "intermediate" from 2 to 4 is "ter". Since they are not equal, the output is "No".
 */
import java.io.*;
import java.util.*;

public class SubstringMatching {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String s1=sc.next();
            String s2=sc.next();
            int q=sc.nextInt();
            int n=s1.length();
            int m2=s2.length();
            
            int m=1000000007;
            int lim=Math.max(n,m2);
            long[] p=new long[lim];
            int x=51;
            p[0]=x;
            for(int i=1;i<lim;i++)
            {
                p[i]=(p[i-1]*x)%m;
            }
            long[] pha=new long[n];
            pha[0]=s1.charAt(0)*x;
            for(int i=1;i<n;i++)
            {
                pha[i]=(pha[i-1]+(s1.charAt(i)*p[i])%m)%m;
            }
            long[] phb=new long[m2];
           phb[0]=s2.charAt(0)*x;
            for(int i=1;i<m2;i++)
            {
                phb[i]=(phb[i-1]+(s2.charAt(i)*p[i])%m)%m;
            }
            
            while(q-->0)
               {
                int i=sc.nextInt();
                int j=sc.nextInt();
                int k=sc.nextInt();
                int l=sc.nextInt();
                long h1=(long)(pha[j]-((i==0)?0:pha[i-1])+m)%m;
                long h2=(long)(phb[l]-((k==0)?0:phb[k-1])+m)%m;
                h1=(h1*p[k])%m;
                h2=(h2*p[i])%m;
                if(h1==h2)
                    System.out.println("Yes");
                else
                    System.out.println("No");
                     
            }
            t--;
        }
    }
}