import java.util.*;
import java.io.*;

public class LargestRectangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(largestrectanglearea(arr));
        sc.close();
    }
    public static int largestrectanglearea(int[] heights) {
        int N=heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[N];
        int[] right = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                right[i] = N;
            else
                right[i] = stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            int area =  heights[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea; 
    }
}