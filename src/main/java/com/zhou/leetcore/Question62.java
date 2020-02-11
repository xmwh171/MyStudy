package com.zhou.leetcore;

import java.util.Arrays;

/**
 * @Description 不同路径
 * @Author xiaohu
 * @Date 2020/1/21 9:26
 */
public class Question62 {

    /**
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     问总共有多少条不同的路径？
     例如，上图是一个7 x 3 的网格。有多少可能的路径？
     说明：m 和 n 的值均不超过 100。
     示例 1:
     输入: m = 3, n = 2
     输出: 3
     解释:
     从左上角开始，总共有 3 条路径可以到达右下角。
     1. 向右 -> 向右 -> 向下
     2. 向右 -> 向下 -> 向右
     3. 向下 -> 向右 -> 向右
     示例 2:
     输入: m = 7, n = 3
     输出: 28
     */

    /**
     *
     * 动态规划
     * 定义状态：dp[i][j]：表示机器人走到某坐标处的总路径
     * 状态方程：dp[i][j] = dp[i-1][j]+dp[i][j-1]
     * 初始化：dp[0][j]=1,dp[i][0]=1
     *
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 优化1
     * 空间复杂度 O(2n)
     * 由于dp[i][j] = dp[i-1][j] + dp[i][j-1]，因此只需要保留当前行与上一行的数据 (在动态方程中，即pre[j] = dp[i-1][j])，两行，空间复杂度O(2n)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }

    /**
     * 优化2
     * 空间复杂度 O(n)
     * cur[j] += cur[j-1], 即cur[j] = cur[j] + cur[j-1] 等价于思路二-->> cur[j] = pre[j] + cur[j-1]，因此空间复杂度为O(n)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths3(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths2(3,2));
        System.out.println(uniquePaths3(3,2));
    }
}
