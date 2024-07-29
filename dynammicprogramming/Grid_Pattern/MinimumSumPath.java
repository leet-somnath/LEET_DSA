<<<<<<< HEAD
class Solution {
    public int minPathSum(int[][] arr) {
           int m=arr.length;
        int n=arr[0].length;
          int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(m - 1, n - 1, dp,arr);
    }


     static int helper(int i,int j,int dp[][],int arr[][])
    {
       
        if(i==0 && j==0)return arr[0][0];
        if(i<0 || j<0) return (int) Math.pow(10, 9); 
         if (dp[i][j] != -1)
            return dp[i][j];
        int up=arr[i][j]+helper(i-1,j,dp,arr);
        int down=arr[i][j]+helper(i,j-1,dp,arr);
        return dp[i][j]=Math.min(up,down);
    
    }
=======
class Solution {
    public int minPathSum(int[][] arr) {
           int m=arr.length;
        int n=arr[0].length;
          int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(m - 1, n - 1, dp,arr);
    }


     static int helper(int i,int j,int dp[][],int arr[][])
    {
       
        if(i==0 && j==0)return arr[0][0];
        if(i<0 || j<0) return (int) Math.pow(10, 9); 
         if (dp[i][j] != -1)
            return dp[i][j];
        int up=arr[i][j]+helper(i-1,j,dp,arr);
        int down=arr[i][j]+helper(i,j-1,dp,arr);
        return dp[i][j]=Math.min(up,down);
    
    }
>>>>>>> 504a43f5310a405e785594a6b52cb9f857ad9822
}