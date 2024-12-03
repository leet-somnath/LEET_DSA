public boolean isNStraightHand(int[] hand, int groupSize) {
    if(hand.length%groupSize!=0){
        return false;
    }
    if(groupSize==1)
        return true;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
    Arrays.sort(hand);
    for(int i:hand){
        if(pq.isEmpty() || pq.peek()[0]==i){
            pq.add(new int[]{i, 1});
        } else if(i>pq.peek()[0]+1){
            return false;
        } else {
            int[] tmp = pq.poll();
            tmp[0] = i;
            tmp[1]++;
            if(groupSize>tmp[1]){
                pq.add(tmp);
            }
        }
    }
    if(pq.isEmpty()){
        return true;
    }
    return false;
}