package com.zhou.leetcore;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 两数之和
 *
 * @Author xiaohu
 * @Date 2020/1/15 18:41
 */
public class Question1 {

    /**
     *
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     示例:
     给定 nums = [2, 7, 11, 15], target = 9
     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     */

    /**
     * 利用hash，时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer index = indexMap.get(target-nums[i]);
            if(index!= null){
                indexs[0] = index;
                indexs[1] = i;
                return indexs;
            }
            indexMap.put(nums[i],i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,23};
        int[] indexs = twoSum(nums,12);
        for(int i=0;i<indexs.length;i++){
            System.out.println(indexs[i]);
        }
    }

}
