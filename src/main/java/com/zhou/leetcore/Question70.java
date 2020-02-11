package com.zhou.leetcore;

/**
 * @Description 爬楼梯
 * @Author xiaohu
 * @Date 2020/1/21 9:26
 */
public class Question70 {

    /**
     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     注意：给定 n 是一个正整数。
     示例 1：
     输入： 2
     输出： 2
     解释： 有两种方法可以爬到楼顶。
     1.  1 阶 + 1 阶
     2.  2 阶
     示例 2：
     输入： 3
     输出： 3
     解释： 有三种方法可以爬到楼顶。
     1.  1 阶 + 1 阶 + 1 阶
     2.  1 阶 + 2 阶
     3.  2 阶 + 1 阶
     */

    /**
     * 动态规划
     * 定义状态：d[n]：表示爬上b阶的方法
     * 状态方程：d[n] = d[n-1]+d[n-2]
     * 初始化：d[0]=1,d[1]=1
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
