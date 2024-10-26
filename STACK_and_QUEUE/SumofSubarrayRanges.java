/*class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0; i<n; i++){
            int max = nums[i];
            int min = nums[i];
            for(int j=i; j<n; j++){
                max = Math.max(nums[j],max);
                min = Math.min(nums[j],min);
                ans += max-min;
            }
        }
        return ans;
    }
} */
class Solution {
    public static long subArrayRanges(int[] nums) {
        return sumOfSubarrayMax(nums) - sumOfSubarrayMin(nums);
    }

    private static long sumOfSubarrayMax(int[] nums) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        long totalMaxSum = 0;

        // Calculate left array for maximum
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            /* while stack is not empty and if stored index value of element 
            is smaller than the current pointing element then decrement the top pointer*/
            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }
            /* if the stack is empty then insert left[] "i+1" 
            else insert the 'i-stack[top] in left[] 
            ultimately storing the index value of the previous larger element for each 
            element of the array*/
            left[i] = (top == -1 ? i + 1 : i - stack[top]);
            stack[++top] = i;
        }
        // Calculate right array for maximum
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            /* while stack is not empty and if stored index value of element 
            is smaller than the current pointing element then decrement the top pointer*/
            while (top >= 0 && nums[stack[top]] < nums[i]) {
                top--;
            }
            /* if the stack is empty then insert right[] "n-1" 
            else insert the 'stack[top]-i" in right[] 
            ultimately storing the index value of the next larger element for each element
            of the array*/
            right[i] = (top == -1 ? n - i : stack[top] - i);
            stack[++top] = i;
        }

        // Calculate total contribution as max
        for (int i = 0; i < n; i++) {
            totalMaxSum += nums[i] * left[i] * right[i];
        }

        return totalMaxSum;
    }

    private static long sumOfSubarrayMin(int[] nums) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        long totalMinSum = 0;

        // Calculate left array for minimum
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && nums[stack[top]] >= nums[i]) {
                top--;
            }
            left[i] = (top == -1 ? i + 1 : i - stack[top]);
            stack[++top] = i;
        }

        // Calculate right array for minimum
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[stack[top]] > nums[i]) {
                top--;
            }
            right[i] = (top == -1 ? n - i : stack[top] - i);
            stack[++top] = i;
        }

        // Calculate total contribution as min
        for (int i = 0; i < n; i++) {
            totalMinSum += nums[i] * left[i] * right[i];
        }

        return totalMinSum;
    }

}