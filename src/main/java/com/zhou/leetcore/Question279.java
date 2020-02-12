package com.zhou.leetcore;

/**
 * @Description 完全平方数
 * @Author xiaohu
 * @Date 2020/1/21 9:47
 */
public class Question279 {

    /**
     给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     示例 1:
     输入: n = 12
     输出: 3
     解释: 12 = 4 + 4 + 4.
     示例 2:
     输入: n = 13
     输出: 2
     解释: 13 = 4 + 9.
     */

    /**
     * 动态规划
     * 状态定义：dp(i)是和为i的完全平方数个数最少的数量
     * 状态方程：dp(i)=min{dp(i-a[i])+1...}
     * 初始化：  dp(0)=0,dp(1)=1;
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        if(n<=0){
           return 0;
        }
        int[] dp = new int[n+1];
        int maxSqrt = (int)Math.sqrt(n);
        int[] nums = new int[maxSqrt];
        for(int i=0;i<maxSqrt;i++){
            nums[i]=(int)Math.pow(i+1,2);
        }
        for(int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]&&dp[i-nums[j]]+1!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i-nums[j]]+1,dp[i]);
                }
            }
        }
        return dp[n];
    }

    /**
     * 优化
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            d[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }
        return d[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(13));
        System.out.println(numSquares2(13));
    }
}
