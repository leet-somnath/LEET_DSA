/*
 * class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int sum = 0;

        // check if roundtrip is feasible
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0)
            return -1;

        // find the starting station
        int tank = 0;
        int station = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                station = i + 1;
                tank = 0;
            }
        }

        return station;
    }
}
 */

public class CircularTourGasStation {

    // Method to find the first petrol pump from where we can complete the circular tour
    public static int firstPetrolPump(int[] petrol, int[] dist, int n) {
        for (int start = 0; start < n; start++) {
            int curr_petrol = 0;
            int end = start;

            while (true) {
                curr_petrol += petrol[end] - dist[end];

                if (curr_petrol < 0) {
                    break;
                }

                end = (end + 1) % n;

                // If we come back to the start, return the starting point
                if (end == start) {
                    return start + 1; // returning the 1-based index
                }
            }
        }
        return -1; // If no solution exists
    }
    // optimal o(1)
    static int firstPetrolPumpop(int petrol[], int dist[],int n)
    {
        int start=0,curr_petrol=0,prev=0;
        for (int i = 0; i < dist.length; i++) {
            curr_petrol+=(petrol[i]-dist[i]);
            if(curr_petrol<0)
            {
                start=i+1;
                prev=curr_petrol;
                curr_petrol=0;
            }
        }
        return (curr_petrol>=0?start+1:-1);
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4}; // Example petrol values at each petrol pump
        int[] dist = {6, 5, 3, 5};   // Example distance to the next petrol pump

        int n = petrol.length;

        int result = firstPetrolPump(petrol, dist, n);

        if (result == -1) {
            System.out.println("No circular tour is possible");
        } else {
            System.out.println("The first petrol pump to start the tour is: " + result);
        }
    }
}
