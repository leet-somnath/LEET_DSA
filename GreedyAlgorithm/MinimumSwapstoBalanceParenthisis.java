class Solution {
    public int minSwaps(String s) {
        int swpCnt = 0;
        int closeCnt = 0;
        int size = s.length(), left = 0, right = size-1;
        while(right > -1 && s.charAt(right) != '[')right--;
        while(left < right){
           if(s.charAt(left) == ']'){
             closeCnt++;
           }else{
            closeCnt--;
           }
           if(closeCnt > 0){
            //   System.out.println(left + " " + right + " " + closeCnt);
              closeCnt-=2;
              right--;
              swpCnt++;
              while(right > left && s.charAt(right) != '[' )right--;
           }
           left++;
        }
        return swpCnt;
    }
}