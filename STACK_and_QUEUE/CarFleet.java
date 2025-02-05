class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;

        double[] times = new double[target];

        for(int i=0;i<position.length;i++) {
            times[position[i]] = (double) (target - position[i]) / speed[i];
        }

        double max = 0;
        for(int i=times.length-1;i>=0;i--) {
            if(times[i] > max) {
                res++;
                max = times[i];
            }
        }

        return res;
    }
}
/*
 * class Solution {
   public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        for (int i = 0; i < position.length; i++) {
            pq.offer(List.of(position[i], speed[i]));
        }
        
        for (int i = 0; i < position.length; i++) {
            List<Integer> value = pq.poll();
            double arrivalTime = ((double)(target - value.get(0))) / value.get(1);
            while (!stack.isEmpty() && arrivalTime >= stack.peek()) {
                stack.pop();
            }
            stack.push(arrivalTime);
        }
        return stack.size();
    }
}
 */