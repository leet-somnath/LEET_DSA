public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        // Edge case for an empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        long result = 0;

        // Step 1: Discard leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle the sign if present
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert the characters to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            i++;

            // Step 4: Handle overflow
            if (result > Integer.MAX_VALUE) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        String str = "  -42";
        int result = myAtoi(str);
        System.out.println("The converted integer is: " + result);
    }
}
