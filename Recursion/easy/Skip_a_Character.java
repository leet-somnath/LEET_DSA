import java.util.*;

public class Skip_a_Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(removedCharString(s, c, 0));
        sc.close();
    }

    static String ans = "";

    public static String removedCharString(String s, char c, int i) {
        if (i == s.length()) {
            return ans;
        }
        if (s.charAt(i) != c) {
            ans += s.charAt(i);
        }
        return removedCharString(s, c, i + 1);
    }
}