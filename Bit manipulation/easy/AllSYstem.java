import java.util.*;
import java.io.*;

public class AllSYstem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // decimal to other system
        System.out.println(Integer.toBinaryString(5)); // op:- 101
        System.out.println(Integer.toHexString(22)); //16
        System.out.println(Integer.toOctalString(15)); //17
        // another system to decimal
        System.out.println(Integer.parseInt("101",2)); //5
        System.out.println(Integer.parseInt("16",16)); //22
        System.out.println(Integer.parseInt("17",8)); //15
        //similarly we can use Long.paramerter
        sc.close();
    }
}