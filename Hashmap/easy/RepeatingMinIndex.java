/*

Given an integer array, find the minimum index of a repeating element in linear time and
 doing just a single traversal of the array.

Input : [5, 6, 3, 4, 3, 6, 4]
Output: 1
Explanation: The minimum index of the repeating element is 1

Input : [1, 2, 3, 4, 5, 6]
Output: -1
Explanation: Input doesn't contain any repeating element

*/
 //solution-->
 



import java.util.HashMap;
import java.util.Map;

public class RepeatingMinIndex {
   public static void main(String args[]){
     int x[]={1, 2, 3, 4, 5, 6};
     int len=x.length,minindex=Integer.MAX_VALUE;
      Map<Integer, Integer> sumMap = new HashMap<>();
      for(int i=0;i<len;i++){
        if(sumMap.containsKey(x[i])){
            minindex = Math.min(minindex, sumMap.get(x[i]));
        }
        else{
            sumMap.put(x[i],i);
        }
      }
      if (minindex == Integer.MAX_VALUE) {
        minindex = -1;
    }

      System.out.println(minindex);
   } 
}
