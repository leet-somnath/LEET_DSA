class Solution {
  static int f(String s,String p,int i,int j,int dp[][]){
      if(i<0 && j<0) return 1;
      if(i<0 && j>=0) return 0;
      if(j<0 && i>=0){
          for(int ii=0;ii<=i;ii++){
             if(p.charAt(ii)!='*'){
              return 0;
             }
          }
          return 1;
      }
      if(dp[i][j]!=-1) return dp[i][j];
      if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
          return dp[i][j]=f(s,p,i-1,j-1,dp);
      }else if(p.charAt(i)=='*'){
          return dp[i][j]=(f(s,p,i-1,j,dp)==1 || f(s,p,i,j-1,dp)==1)?1:0;
      }
    return 0;
  }
  public boolean isMatch(String s, String p) {
      int n=s.length(),m=p.length();
      int dp[][]=new int[m+1][n+1];
      for(int r[]:dp) Arrays.fill(r,-1);
      int k=f(s,p,m-1,n-1,dp);
      if(k==1) return true;
      return false;
  }
}