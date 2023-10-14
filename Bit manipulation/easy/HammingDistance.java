/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int c=0;
        for(int i=0;i<32;i++)
        {

            int k= (x&(1<<i))>0?1:0;
            int l= (y&(1<<i))>0?1:0;
            if(k!=l)
            c++;
        }
        return c;
    }
}
// @lc code=end

