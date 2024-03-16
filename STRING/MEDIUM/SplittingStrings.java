import java.io.*;
import java.util.*;

public class SplittingStrings {

    public static boolean perfect(String str){
        char c=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=c){
                return false;
            }
        }
        return true;
    }

    public static int solve(String str,int cut){

        if(perfect(str)){
            return cut;
        }
        int n=str.length();
        if(n%2!=0){
            return Integer.MAX_VALUE;
        }
        int L=solve(str.substring(0,n/2),cut+1);
        int R=solve(str.substring(n/2,n),cut+1);
        return Math.min(L,R);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0){
            String str=sc.next();
            int ans=solve(str,0);
            if(ans==Integer.MAX_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(ans);
            }
        }
        
    }
}