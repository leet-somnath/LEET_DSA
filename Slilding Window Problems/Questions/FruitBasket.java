class Solution {
    public static int totalFruits( int[] fruits) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxlen = 0;

        while (r < fruits.length) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            while (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}
/* https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1 */