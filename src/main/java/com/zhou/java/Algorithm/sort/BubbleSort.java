package com.zhou.java.Algorithm.sort;

/**
 * @Description
 * 最简单的一种排序算法。
 * 假设长度为n的数组arr，要按照从小到大排序。
 * 则冒泡排序的具体过程可以描述为：首先从数组的第一个元素开始到数组最后一个元素为止，对数组中相邻的两个元素进行比较，如果位于数组左端的元素大于数组右端的元素，则交换这两个元素在数组中的位置，此时数组最右端的元素即为该数组中所有元素的最大值。接着对该数组剩下的n-1个元素进行冒泡排序，直到整个数组有序排列。算法的时间复杂度为O(n^2)。
 * @Author xiaohu
 * @Date 2020/5/15 17:01
 */
public class BubbleSort {


    public static void sort(int arr[]){
        int length = arr.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,7,9,2,6,8};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
