/* Given an unsorted integer array, find the first missing positive integer.
Your algorithm should run in O(n) time and use constant space.


Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 106


Input Format
The first argument is an integer array A.


Output Format
Return an integer equal to the first missing positive integer


Example Input
Input 1:
A = [1,2,0]
Input 2:
A = [3,4,-1,1]
Input 3:
A = [-8,-7,-6]


Example Output
Output 1:
3
Output 2:
2
Output 3:
1


Example Explanation
Explanation 1:
3 is the first positive missing integer.
Explanation 2:
2 is the first positive missing integer.
Explanation 3:
1 is the first positive missing integer. */

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {
   public static void main(String args[])
   {
            Scanner sc = new Scanner(System.in);
            
           int n=sc.nextInt();
          ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++){ 
                   a.add(sc.nextInt());
     }
            int res=firstMissingPositive(a);
            System.out.println(res);
   }
    public static int firstMissingPositive(ArrayList<Integer> A) {
        // Remove non-positive numbers
        A.removeIf(n -> n <= 0);
        Collections.sort(A);
        int N = A.size();
        for (int i = 0; i < N; i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        return N + 1;
    }
}
