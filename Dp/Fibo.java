package Dp;

import java.util.*;

public class Fibo {

        static int n=6;
        static int []dp=new int[n+1];

//    static int fibo(int n){
//        if(n<=1)return n;
//        return fibo(n-1)+fibo(n-2);
//    }

//    static int fiboDPMemo(int n){
//        if(n<=1)return n;
//
//        if(dp[n]!=-1){
//            return dp[n];
//        }
//       dp[n]=fiboDPMemo(n-1)+fiboDPMemo(n-2);
//        return dp[n];
//    }
    static int fiboDPTab(int n){

        dp[1]=1;
        dp[0]=0;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
//        Arrays.fill(dp,-1);
        System.out.println(fiboDPTab(n));
    }
}
