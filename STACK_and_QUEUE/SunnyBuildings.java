import java.util.*;
import java.io.*;

public class SunnyBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans[]=closestgreaterElementOnLeftside(arr);
        System.out.println(Arrays.toString(ans));
        sc.close();
    }
    public static int [] closestgreaterElementOnLeftside(int arr[])
    {
       Deque<Integer> st=new ArrayDeque<>();
       int ans[]=new int[arr.length];
       for(int i=0;i<arr.length;i++)
       {
            while(!st.isEmpty() && arr[i]>=arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=-1;
            }
            else
                ans[i]=st.peek();
            st.push(i);
       }
       return ans;
    }

}