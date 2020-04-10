package com.zhou.base.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/4/10 12:39
 */
public class HwQ_2 {

    public static List<List<Integer>> solution(int startNum, int endNum){
        List<List<Integer>> listList = new ArrayList<>();
        for(int i=startNum;i<endNum-2;i++){
            for(int j=i+1;j<endNum-1;j++ ){
                for(int k=j+1;k<endNum;k++){
                    if(checkGg(i,j,k)&&checkHuZhi(i,j)&&checkHuZhi(i,k)&&checkHuZhi(j,k)){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        listList.add(list);
                    }
                }
            }
        }
        return listList;
    }

    private static boolean checkGg(int a, int b ,int c){
        return (Math.pow(a,2)+Math.pow(b,2) == Math.pow(c,2))?true:false;
    }

    /**
     * 欧几里得算法
     * @param n
     * @param m
     * @return
     */
    public static boolean checkHuZhi(int n, int m){
        int t=0;
        while(m>0) {
            t=n%m;
            n=m;
            m=t;//当=0说明两个数之间存在倍数关系
        }
        if(n==1)return true;
        return false;
    }

    /**
     * 输入两个数：n < m
     1<= n <=200
     1< m <200

     输出：两数中所有满足下列条件的三数列：a b c ，若没有则输出'NA'
     注：
     1. 满足 a^2 + b^2 = c^2 ，且a、b、c两两互为质数
     2. a < b < c  且按照a升序，b升序，c升序输出

     例：
     输入：1   20

     输出：3  4  5
     5 12 13
     。。。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(1,200));
    }

}
