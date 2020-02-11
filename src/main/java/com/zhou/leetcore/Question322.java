package com.zhou.leetcore;

/**
 * @Description 零钱兑换
 * @Author xiaohu
 * @Date 2020/1/21 9:48
 */
public class Question322 {

    /**
     给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     示例 1:
     输入: coins = [1, 2, 5], amount = 11
     输出: 3
     解释: 11 = 5 + 5 + 1
     示例 2:
     输入: coins = [2], amount = 3
     输出: -1
     说明:
     你可以认为每种硬币的数量是无限的。
     */

    /**
     * 动态规划
     * 状态定义： dp[i] 为i元所需的最少硬币
     * 状态方程： dp[i]= min{dp[i-1]+1、dp[i-2]+1、dp[i-5]+1}
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
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]]+1, dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,27));
    }
}
