class Solution {
    //we are using TreeMap instead of a HashMap because a TreeMap stores data in sorted order based on the  Key 
    public String intToRoman(int num) {
       TreeMap<Integer,String> map = new TreeMap<>();
       map.put(1,"I"); 
       map.put(4,"IV");
       map.put(5,"V");
       map.put(9,"IX");
       map.put(10,"X");
       map.put(40,"XL");
       map.put(50,"L");
       map.put(90,"XC");
       map.put(100,"C");
       map.put(400,"CD");
       map.put(500,"D");
       map.put(900,"CM");
       map.put(1000,"M");

       int runningNum = num;
       String result = "";

       while(runningNum>0){
           Integer closestKey = map.floorKey(runningNum);
           result += map.get(closestKey);
           runningNum = runningNum - closestKey;
       }

       return result;
    }
}