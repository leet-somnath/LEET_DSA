class Solution {
    public int maxAbsValExpr(int[] a1, int[] a2) {
        int max=0;
        //++, +-, -+, -- +i
        int[] dp = new int[4];
        dp[0]=a1[0]+a2[0];
        dp[1]=a1[0]-a2[0];
        dp[2]=-a1[0]+a2[0];
        dp[3]=-a1[0]-a2[0];

        int[] t = new int[4];
        int x;
        for(int i=1; i<a1.length; i++){
            t[0]=a1[i]+a2[i]+i;
            t[1]=a1[i]-a2[i]+i;
            t[2]=-a1[i]+a2[i]+i;
            t[3]=-a1[i]-a2[i]+i;

            for(int k=0; k<4; k++){
                x=t[k]-dp[k];
                if(max<x)max=x;
                if(dp[k]>t[k])dp[k]=t[k];
            }
        }
        return max;
    }
}
/*class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        for(int i = 0; i < arr1.length; i++)
        {
            max1 = Math.max(arr1[i] + arr2[i] + i, max1);
            max2 = Math.max(arr1[i] + arr2[i] - i, max2);
            max3 = Math.max(arr1[i] - arr2[i] + i, max3);
            max4 = Math.max(arr1[i] - arr2[i] - i, max4); 
            min1 = Math.min(arr1[i] + arr2[i] + i, min1);
            min2 = Math.min(arr1[i] + arr2[i] - i, min2);
            min3 = Math.min(arr1[i] - arr2[i] + i, min3);
            min4 = Math.min(arr1[i] - arr2[i] - i, min4);
        }
        return Math.max(Math.max(max1 - min1, max2-min2), Math.max(max3-min3, max4 - min4));
    }
} */