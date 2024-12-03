class Solution {
    public int minCostToMoveChips(int[] position) {
        int e=0,o=0;
        for(int i:position){
            if(i%2==0) e++;
            else o++;
        }
        return Math.min(e,o);
    }
}