package com.zhou.leetcore;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description 解码方法
 * @Author xiaohu
 * @Date 2020/1/21 9:27
 */
public class Question91 {

    /**
     一条包含字母 A-Z 的消息通过以下方式进行了编码：
     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     给定一个只包含数字的非空字符串，请计算解码方法的总数。
     示例 1:
     输入: "12"
     输出: 2
     解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     示例 2:
     输入: "226"
     输出: 3
     解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */

    /**
     * 动态规划
     * 定义状态:  dp[i] 为str[0..i]译码方法总数
     * 状态方程： 若s[i]='0',那么若s[i-1]='1'or'2',则dp[i]=dp[i-2];否则返回0   解释：s[i-1]+s[i]唯一被译码，不增加情况
     *           若s[i-1]='1',则dp[i]=dp[i-1]+dp[i-2]                       解释：s[i-1]与s[i]分开译码，为dp[i-1];合并译码为dp[i-2]
     *           若s[i-1]='2'and 1<=s[i]<='6',则dp[i]=dp[i-1]+dp[i-2]       解释：同上
     * 分析可知，dp[i]仅可能与前两项有关，故可以用单变量代替dp[]数组，将空间复杂度从O(n)降到O(1)
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int len = s.length();
        if(len<1){
            return 0;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
        int pre=1,curr=1;
        for(int i=1;i<len;i++){
            int tmp = curr;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    curr = pre;
                }else {
                    return 0;
                }
            }else if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)>='1'&&s.charAt(i)<='6')){
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

    // 312  321  328  101  100  53  120

    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
    }
}
