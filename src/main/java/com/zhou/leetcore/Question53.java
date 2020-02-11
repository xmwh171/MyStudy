package com.zhou.leetcore;

/**
 * @Description 最大子序和
 * @Author xiaohu
 * @Date 2020/1/21 9:25
 */
public class Question53 {

    /**
     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     示例:
     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     进阶:
     如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    /**
     * 动态规划解法
     * 定义状态：dp[i]:是nums[i]结尾的连续子数组的最大和
     * 状态方法：dp[i] = max{dp[i-1],dp[i-1]+nums[i]}
     * 初始化：dp[0]= nums[0]
     * 计算顺序：正序
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }
            int res = dp[0];
            for (int i = 1; i < len; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
    }

    /**
     * 思考状态压缩
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            // 起名叫 pre 表示的意思是“上一个状态”的值
            int pre = nums[0];
            int res = pre;
            for (int i = 1; i < len; i++) {
                pre = Math.max(nums[i], pre + nums[i]);
                res = Math.max(res, pre);
            }
            return res;
    }

    public static int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }

}
