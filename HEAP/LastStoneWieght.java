import java.util.*;
import java.io.*;

public class LastStoneWieght {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int x:arr)
            {
                pq.offer(x);
            }
            while(pq.size()>1)
            {
                int x=pq.poll();
                int y=pq.poll();
                if(x!=y)pq.offer(x-y);
            }
            System.out.println(pq.isEmpty()?0:pq.poll());
        sc.close();
    }
}