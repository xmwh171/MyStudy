package com.zhou.java.Test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/4/23 17:08
 */
public class TestCoin {

    /**
     * 动态规划
     * 状态定义： dp[i]为所有个数
     * 状态方程： dp[i]= {dp[i-1]+1}+{dp[i-5]+1}+{dp[i-10]+1}+{dp[i-25]+1}
     * 初始化：   dp[0]=0
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if(coins.length==0){
            return -1;
        }
        int[] dp = new int[amount+1];
        for(int i=1;i<dp.length;i++){
            dp[0]=0;
            dp[1]=1;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&dp[i-coins[j]]>0) {
                    dp[i] = dp[i - coins[j]]+1;
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        System.out.println(coinChange(coins,5));
    }


}
