/*

Given a binary array, in-place sort it in linear time and constant space. The output should contain all zeroes, followed by all ones.

Input : [1, 0, 1, 0, 1, 0, 0, 1]
Output: [0, 0, 0, 0, 1, 1, 1, 1]

Input : [1, 1]
Output: [1, 1]

*/

//solution-->

/*
  1.count total no of zeroes,let count variable "c"
  then  insert "c" zeroes in array then
  insert "len-c" no of 1's in array
  that's it ,array is sorted

 */
package Arrays.easy;

import java.util.Arrays;

public class SortBinary {
    public static void main(String args[]){
        int x[]={1, 0, 1, 0, 1, 0, 0, 1};
        int len=x.length,c=0;
        for(int i=0;i<len;i++){
            if(x[i]==0)
            c++;
        }
        for(int i=0;i<len;i++){
            if(i<c){
                x[i]=0;
            }
            else
            x[i]=1;
        }
        System.out.println(Arrays.toString(x));
    }
}
