import java.util.*;
class Roster {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        List<List<Integer>> f = new ArrayList<>();
        for (int i = 0; i < n; i++) f.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = s.nextInt(), y = s.nextInt();
            f.get(x).add(y);
            f.get(y).add(x);
        }
        int k = s.nextInt(), d = 1, r = n;
        boolean[] c = new boolean[n];
        Arrays.fill(c, true);
        while (r < k) {
            d++;
            boolean[] nc = new boolean[n];
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j : f.get(i)) if (c[j]) cnt++;
                if (c[i]) nc[i] = (cnt == 3);
                else nc[i] = (cnt < 3);
            }
            c = nc;
            r += countTrue(c);
        }
        System.out.print(d);
    }

    private static int countTrue(boolean[] arr) {
        int count = 0;
        for (boolean b : arr) if (b) count++;
        return count;
    }
}
