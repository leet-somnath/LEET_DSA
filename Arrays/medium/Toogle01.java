import java.io.*;
import java.util.*;
//smaertintevews
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            TreeSet<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            int q = sc.nextInt();
            while (q-- > 0) {
                int d = sc.nextInt();
                int i = sc.nextInt();
                if (d == 1) {
                    if (set.contains(i)) {
                        set.remove(i);
                    } else {
                        set.add(i);
                    }
                } else {
                    if (set.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        Integer floorVal = set.floor(i);
                        Integer ceilVal = set.ceiling(i);
                        int x = (floorVal != null) ? Math.abs(floorVal - i) : Integer.MAX_VALUE;
                        int y = (ceilVal != null) ? Math.abs(ceilVal - i) : Integer.MAX_VALUE;
                        System.out.println(Math.min(x, y));
                    }
                }
            }
        }
    }
}
