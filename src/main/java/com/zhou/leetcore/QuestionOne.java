package com.zhou.leetcore;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/1/15 18:41
 */
public class QuestionOne {

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
