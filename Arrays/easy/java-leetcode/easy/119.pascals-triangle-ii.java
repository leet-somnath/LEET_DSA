/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
                List<Integer> res = new ArrayList<>();
                res.add(1);
                long prev = 1;
                for (int k = 1; k <= rowIndex; k++) {
                    long next_val = prev * (rowIndex - k + 1) / k;
                    res.add((int) next_val);
                    prev = next_val;
                }
                return res;
            
    }
}
// @lc code=end

