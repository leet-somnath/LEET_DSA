class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        
        int[] prime = new int[n];  // 0 means prime
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j < n; j += i) { // Start from i*i
                    prime[j] = 1;
                }
            }
        }
        
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == 0) res++;
        }
        return res;
    }
}