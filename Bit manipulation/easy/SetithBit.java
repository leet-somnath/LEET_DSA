import java.util.*;
 import java.io.*;
public class SetithBit {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        int n=sc.nextInt();
        int i=sc.nextInt();
        int res=n|(1<<i);
        System.out.println(res);
sc.close();
    }
}