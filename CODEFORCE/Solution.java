import java.util.*;
public class Solution
{
public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int c=0;
int k=sc.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++)
{
a[i]=sc.nextInt();
}

for(int i=0;i<n;i++)
{
if(a[i]>0 && a[i]>=a[k-1])
c++;
else 
break;}
System.out.println(c);
}
}