import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int flag=0;
            
            for (int i : arr) {
                int sum = k +i;
                if(sum==i)
                {
                     if(map.get(sum)>1)
                         
                     {flag=1;
                      break;
                     }
                }
                else if (map.containsKey(sum)) {
                    flag=1;
                    break;
                }
            }

          if(flag==1)
              System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
