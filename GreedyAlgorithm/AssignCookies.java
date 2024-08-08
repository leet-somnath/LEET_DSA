
import java.util.Arrays;

public class AssignCookies {
    // Function to find the maximum
    // number of content children
    public static int findContentChildren(int[] greed, int[] cookieSize) {
        // Get the size of
        // the greed array
        int n = greed.length;

        // Get the size of
        // the cookieSize array
        int m = cookieSize.length;

        // Sort the greed factors in ascending
        // order to try and satisfy the
        // least greedy children first
        Arrays.sort(greed);

        // Sort the cookie sizes in ascending
        // order to use the smallest cookies first
        Arrays.sort(cookieSize);

        // Initialize a pointer for the
        // cookieSize array, starting
        // from the first cookie
        int l = 0;

        // Initialize a pointer for the
        // greed array, starting from
        // the first child
        int r = 0;

        // Iterate while there are
        // cookies and children
        // left to consider
        while (l < m && r < n) {
            // If the current cookie can
            // satisfy the current child's greed
            if (greed[r] <= cookieSize[l]) {
                // Move to the next child,
                // as the current child is satisfied
                r++;
            }
            // Always move to the next cookie
            // whether the current child
            // was satisfied or not
            l++;
        }

        // The value of r at the end of
        // the loop represents the number
        // of children that were satisfied
        return r;
    }

    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookieSize = {4, 2, 1, 2, 1, 3};
        
        System.out.print("Array Representing Greed: ");
        for (int i = 0; i < greed.length; i++) {
            System.out.print(greed[i] + " ");
        }
        System.out.println();
        
        System.out.print("Array Representing Cookie Size: ");
        for (int i = 0; i < cookieSize.length; i++) {
            System.out.print(cookieSize[i] + " ");
        }

        int ans = findContentChildren(greed, cookieSize);

        System.out.println();
        System.out.println("No. of kids assigned cookies " + ans);
        System.out.println();
    }
}

{

}
