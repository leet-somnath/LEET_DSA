import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr= Arrays.asList(3,3,3,34,3);
        // filter and foreacch

        arr.stream().filter(x->x%2==0).forEach(x->System.out.println(x));
       
        //map in streams

        arr.stream().map(x->x+2).forEach(x->System.out.println(x));

        // collect in streams

        List<String> names = Arrays.asList(
            "Reflection", "Collection", "Stream");
            List<String> result
            = names.stream()
              .filter(s -> s.startsWith("S"))
              .collect(Collectors.toList());
              System.out.println(result);

              // sorted in stream
              
         List<Integer> ar=arr.stream().sorted().collect(Collectors.toList());
         System.out.println(ar);
        sc.close();
    }
}