/*

Given an unsorted integer array, find a pair with the given sum in it.

• Each input can have multiple solutions. The output should match with either one of them.

Input : nums[] = [8, 7, 2, 5, 3, 1], target = 10
Output: (8, 2) or (7, 3)

• The solution can return pair in any order. If no pair with the given sum exists, the solution should return null.

Input : nums[] = [5, 2, 6, 8, 1, 9], target = 10
Output: null

*/

//method -1-->
package Arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static void main(String args[]) {
        ArrayList<Integer> x=new ArrayList<>();
        x.add(2);
        x.add(5);
        x.add(3);
        x.add(8);
        x.add(5);
        x.add(2);

        int target = 10;
        List<Integer> pair = findPair(x, target);
        System.out.println(pair);
    }

    public static List<Integer> findPair(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<A.size();i++){
        if(map.containsKey(B-A.get(i))){
        list.add(map.get(B-A.get(i)));
        list.add(i+1);
        break;
        }else{
        if(map.containsKey(A.get(i))){
        continue;
        }else{
        map.put(A.get(i),i+1);
        }
        }
        }
        return list;
    }
}

//2nd mothod-->

/*
 package Arrays.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String args[]) {
        int[] nums = {5, 2, 6, 8, 1, 9};
        int target = 10;
        int[] ans = findPair(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findPair(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
 */