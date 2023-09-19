import java.util.*;
public class kthFrequency {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
//reading
               int n=sc.nextInt();
               int arr[]=new int[n];
                for(int i=0;i<n;i++){ 
              arr[i]=sc.nextInt();
         }
         int k=sc.nextInt();
         //getting frequency
                Map<Integer,Integer> map=new HashMap<>();
                for (int i : arr) {
                    map.put(i,map.getOrDefault(i, 0)+1);
                }
                //printing if frequency is > n/k itmes
                for (int i : arr) {
                    if(map.get(i)>(n/k))
                       System.out.println(i);
                }
}
}