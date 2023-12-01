import java.util.*;
 import java.io.*;
public class Collection {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
                ArrayList<Integer> x=new ArrayList<>();
                ArrayList<Integer> y=new ArrayList<>();
                //common methods
                x.add(5);
                x.add(4);
                y.addAll(x);
                System.out.println(y);
                y.removeAll(x);
                System.out.println(y);
                x.clear();
                System.out.println(x);
                System.out.println(x.isEmpty());
                x.contains(4);
                x.size();
                HashSet<Integer> z=new HashSet<>();
                z.add(10);
                
sc.close();
    }
}