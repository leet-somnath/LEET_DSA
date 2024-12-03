import java.util.*;

class KMPStringMatchingINTwoDarrray {
    // Prints occurrences of pat[] in txt[]
    static int KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest prefix
        // suffix values for pattern
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);
        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        int cnt = 0; // to store no of occurrence
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                cnt++;
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N
                     && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return cnt;
    }

    // Fills lps[] for given pattern pat[0..M-1]
    static void computeLPSArray(String pat, int M,
                                int[] lps)
    {
        // length of the previous longest prefix suffix
        int len = 0;

        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        String str = "MAGIC";
        String[] input = { "BBABBM", "CBMBBA", "IBABBG",
                           "GOZBBI", "ABBBBC", "MCIGAM" };
        int n = input.length;
        int m = input[0].length();
        int ans = 0;
        // row wise
        for (int i = 0; i < n; i++) {
            String text = input[i];
            // left to right match
            ans += KMPSearch(str, text);
            // right to left match
            ans += KMPSearch(str, new StringBuilder(text)
                                      .reverse()
                                      .toString());
        }

        // column wise;
        for (int i = 0; i < m; i++) {
            StringBuilder text = new StringBuilder();
            for (int j = 0; j < n; j++) {
                text.append(input[j].charAt(i));
            }
            // top to down;
            ans += KMPSearch(str, text.toString());
            // down to top;
            ans += KMPSearch(str,
                             text.reverse().toString());
        }

        System.out.println("Count : " + ans);
    }
}
