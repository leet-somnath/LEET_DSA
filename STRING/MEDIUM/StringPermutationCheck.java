public class StringPermutationCheck {

    public static boolean isScramble(String a, String b) {
        // Base case: if the strings are of length 1
        if (a.length() == 1) {
            return a.equals(b);
        }
        
        int n = a.length();
        
        // Recursive case: try splitting the string at every possible index
        for (int i = 1; i < n; i++) {
            // Divide the string a into two parts: x and y
            StringBuffer x = new StringBuffer(a.substring(0, i));
            StringBuffer y = new StringBuffer(a.substring(i));
            
            // Check if x + y equals b
            StringBuffer xy = new StringBuffer().append(x).append(y);
            if (xy.toString().equals(b)) {
                return true;
            }
            
            // Check if y + x equals b
            StringBuffer yx = new StringBuffer().append(y).append(x);
            if (yx.toString().equals(b)) {
                return true;
            }
            
            // Recursively check the substrings
            if ((isScramble(x.toString(), b.substring(0, i)) && 
                 isScramble(y.toString(), b.substring(i))) ||
                (isScramble(y.toString(), b.substring(0, n - i)) && 
                 isScramble(x.toString(), b.substring(n - i)))) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        System.out.println(isScramble(a, b)); // Output: true
    }
}
