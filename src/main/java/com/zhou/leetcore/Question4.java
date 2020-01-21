package com.zhou.leetcore;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description 寻找两个有序数组的中位数
 * @Author xiaohu
 * @Date 2020/1/16 13:01
 */
public class Question4 {

    /**
     *
     给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     你可以假设 nums1 和 nums2 不会同时为空。
     示例 1:
     nums1 = [1, 3]
     nums2 = [2]
     则中位数是 2.0
     示例 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     则中位数是 (2 + 3)/2 = 2.5
     */

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int[] temp = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,temp,0,nums1.length);
        System.arraycopy(nums2,0,temp, nums1.length,nums2.length);
        Arrays.sort(temp);
        if(temp.length%2==0){
            result = (double) (temp[(temp.length/2-1)] + temp[temp.length/2])/2;
        }else{
            result = temp[(temp.length-1)/2];
        }
        return result;
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int l=m+n;

        // 用来记录数组遍历的位置
        int n1=0;
        int n2=0;
        int num1=0;
        int num2=0;

        // 如果能直接在遍历的时侯拿到值, 那么直接就可以得出结果
        while(n1+n2<(l/2+1)){
            if(n1==m){
                num1=num2;
                num2=nums2[n2++];
            }else if(n2==n){
                num1=num2;
                num2=nums1[n1++];
            }else{
                num1=num2;
                num2=nums1[n1]<nums2[n2]?nums1[n1++]:nums2[n2++];
            }
        }

        if((m+n)%2==0){
            return (num1+num2)/2.0;
        }else{
            return (double)num2;
        }
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i != nums1.length || j != nums2.length) {
            if (i == nums1.length) {
                results[i + j] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                results[i + j] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                results[i + j] = nums1[i];
                i++;
            } else {
                results[i + j] = nums2[j];
                j++;
            }
        }
        return (results.length % 2 == 0) ? (double) (results[results.length / 2 - 1] + results[results.length / 2]) / 2 : results[results.length / 2];
        }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5};
        int[] nums2 = new int[]{2,4,8};
        System.out.println(findMedianSortedArrays3(nums1,nums2));
    }
}
