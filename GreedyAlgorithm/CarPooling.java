class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxDist = Integer.MIN_VALUE; // Fixed the incorrect usage of INTEGER.MIN_VALUE
        
        for (int[] trip : trips) {
            maxDist = Math.max(maxDist, trip[2]);
        }

        // Create a cumulative array to track passengers at each location
        int[] dist = new int[maxDist + 1];

        // Populate the array with passengers getting on and off
        for (int[] trip : trips) {
            int currPass = trip[0];
            int from = trip[1];
            int to = trip[2];

            dist[from] += currPass; // Add passengers at the starting point
            dist[to] -= currPass;  // Remove passengers at the ending point
        }

        // Calculate cumulative sum and check capacity
        int currentPassengers = 0;
        for (int i = 0; i <= maxDist; i++) {
            currentPassengers += dist[i];
            if (currentPassengers > capacity) {
                return false; // Capacity exceeded
            }
        }

        return true; 
    }
}
