import java.util.*;

public class NooAnagram {

    static final int charr = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int len = sc.nextInt();
            String list[] = new String[n];
            for (int i = 0; i < n; i++)
                list[i] = sc.next();
                
            ArrayList<ArrayList<String>> anagramGroups = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boolean foundGroup = false;
                for (ArrayList<String> group : anagramGroups) {
                    if (isAnagram(group.get(0), list[i])) {
                        group.add(list[i]);
                        foundGroup = true;
                        break;
                    }
                }
                if (!foundGroup) {
                    ArrayList<String> newGroup = new ArrayList<>();
                    newGroup.add(list[i]);
                    anagramGroups.add(newGroup);
                }
            }
            
            System.out.println(anagramGroups.size());
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int count[] = new int[charr];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i : count) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
