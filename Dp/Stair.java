package Dp;
import java.util.*;

public class Stair {
    static int n=10;
    static int []dp=new int[n+1];

//    static int stair(int n){
//        if(n<=1)return n;
//        return stair(n-1)+stair(n-2);
//    }

    static int stairCost(int []cost,int n){
        if(n<=1)return cost[n];
        int min=Math.min(dp[n-1],dp[n-2]);
       dp[n]=min;
        return min+cost[n];
    }
    public static void main(String[] args) {
        int cost[]=new int[]{1,100,1,1,1,100,1,1,100,1};
        int size=cost.length;
        Arrays.fill(dp,-1);
        System.out.println(Math.min(stairCost(cost,size-1),stairCost(cost,size-2)));
    }
}
