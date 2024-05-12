
import java.util.*;

public class ShortestDistanceWords {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
                
        String s=sc.nextLine();
        String str[]=s.split(" ");
        String w1=sc.next();
        String w2=sc.next();
        int res=0;
        HashMap<String,Integer>map=new HashMap<>();
        for (int j = 0; j < str.length; j++) {
            map.put(str[j], j);
            if(map.containsKey(w1) && map.containsKey(w2))
            {
                int a=map.get(w1);
                int b=map.get(w2);

                int d=Math.abs(a-b);
                res=d-1;
            }
        }
        System.out.println(res);
      
       

sc.close();
    }
}