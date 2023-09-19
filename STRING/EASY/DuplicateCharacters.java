import java.util.*;
public class DuplicateCharacters {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
        Map<Character,Integer> map= new HashMap<>();
               int n=sc.nextInt();
               char ch []=new char[n];
                for(int i=0;i<n;i++){ 
              ch[i]=sc.next().charAt(0);
         }
               for(int i=0;i<n;i++){
                   map.put(ch[i],map.getOrDefault(ch[i],0)+1);
               }
                for (int i = 0; i < ch.length; i++) {
                    if(map.get(ch[i])==2)
                    System.out.print(ch[i]);
                }
    }
}