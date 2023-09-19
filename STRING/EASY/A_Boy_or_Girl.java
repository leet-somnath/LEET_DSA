import java.util.*;

public class A_Boy_or_Girl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user=sc.next();
        HashSet<Character> x=new HashSet<>();
        char ch[]=user.toCharArray();
        for(int i=0;i<ch.length;i++){
            x.add(ch[i]);
        }
        if(x.size()%2==0)
            System.out.println("CHAT WITH HER!");
            else
                System.out.println("IGNORE HIM!");
                sc.close();
    }
}