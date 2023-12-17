import java.util.*;
 import java.io.*;
public class A_Candies_and_Two_Sisters {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(int i=0;i<n;i++)
{
    long a=sc.nextLong();
    if(a%2==0)
    {
        System.out.println((a/2)-1);
    }
    else
    {
        System.out.println(a/2);
    }
}

sc.close();
    }
}