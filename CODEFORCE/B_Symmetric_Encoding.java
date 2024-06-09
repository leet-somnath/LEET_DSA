import java.util.*;
public class B_Symmetric_Encoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            char[] cnt = new char[set.size()];
            int index = 0;
            for (char c : set) {
                cnt[index++] = c;
            }
            Arrays.sort(cnt);
            StringBuilder result = new StringBuilder();
            for (char c : s.toCharArray()) {
                int idx = Arrays.binarySearch(cnt, c);
                result.append(cnt[cnt.length - 1 - idx]);
            }
            System.out.println(result);
        }
        sc.close();
    }
}
