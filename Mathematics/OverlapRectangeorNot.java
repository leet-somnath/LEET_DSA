class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int recx1 = rec1[0]; 
        int recy1 = rec1[1];
        int recx2 = rec1[2];
        int recy2 = rec1[3];

        int rec2x1 = rec2[0]; 
        int rec2y1 = rec2[1];
        int rec2x2 = rec2[2];
        int rec2y2 = rec2[3];

        if(rec2x1 < recx2 && rec2y1 < recy2 && rec2x2 > recx1 && rec2y2 > recy1) return true;
        
        return false;
    }
}