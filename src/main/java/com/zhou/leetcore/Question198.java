package com.zhou.leetcore;

/**
 * @Description 打家劫舍
 * @Author xiaohu
 * @Date 2020/1/21 9:33
 */
public class Question198 {

    /**
     你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     示例 1:
     输入: [1,2,3,1]
     输出: 4
     解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
          偷窃到的最高金额 = 1 + 3 = 4 。
     示例 2:
     输入: [2,7,9,3,1]
     输出: 12
     解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
          偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */

    /**
     * 动态规划
     * 定义：dp[i]:包含i的最大金额(第i间必偷)
     * 方程：dp[i] = dp[i-2]+nums[i-2] or dp [i-3]+nums[i-3]
     * 初始化：dp[0] = nums[0] dp[1]=nums[1]  dp[2]=nums[0]+nums[2]
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len<1){
            return 0;
        }
        int[] dp = new int[nums.length];
        if(len==1){
            return nums[0];
        }
        dp[0] = nums[0];
        if(len==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[1]=nums[1];
        if(len==3){
            return Math.max(nums[0]+nums[2],nums[1]);
        }
        dp[2]=nums[0]+nums[2];
        for(int i=3;i<len;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-3]+nums[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划简化版
     * 第i间不一定偷，dp[n] = MAX( dp[n-1], dp[n-2] + num )
     * 注意：因为n只与n-1,n-2有关，所以可以考虑用变量代替，起到降低空间复杂度
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }


    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1,2};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }
}
