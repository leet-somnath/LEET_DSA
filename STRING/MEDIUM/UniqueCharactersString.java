import java.util.*;
import java.io.*;

public class UniqueCharactersString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String str = sc.nextLine();
        String s[] = str.split(" ");
        System.out.println(maxstring(s));
        sc.close();
    }

    static int maxstring(String s[]) {
        String ans = "";
        return fun(s, ans, 0);
    }

    static int fun(String s[], String ans, int i) {
        if (i == s.length) {
            int freq[] = new int[26];
            Arrays.fill(freq, 0);
            for (int j = 0; j < ans.length(); j++) {
                if (freq[ans.charAt(j) - 'a'] == 1)
                    return 0;
                freq[ans.charAt(j) - 'a']++;
            }
            return ans.length();
        }
        int op1 = Integer.MIN_VALUE, op2 = Integer.MIN_VALUE;
        if (ans.length() + s[i].length() <= 26) {
            op1 = fun(s, ans + s[i], i + 1);
        }
        op2 = fun(s, ans, i + 1);
        return Math.max(op1, op2);
    }
}
