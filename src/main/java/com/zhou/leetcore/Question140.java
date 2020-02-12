package com.zhou.leetcore;

import java.util.*;

/**
 * @Description 单词拆分II
 * @Author xiaohu
 * @Date 2020/1/21 9:30
 */
public class Question140 {

    /**
     给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     说明：
     分隔时可以重复使用字典中的单词。
     你可以假设字典中没有重复的单词。
     示例 1：
     输入:
     s = "catsanddog"
     wordDict = ["cat", "cats", "and", "sand", "dog"]
     输出:
     [
       "cats and dog",
       "cat sand dog"
     ]
     示例 2：
     输入:
     s = "pineapplepenapple"
     wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     输出:
     [
       "pine apple pen apple",
       "pineapple pen apple",
       "pine applepen apple"
     ]
     解释: 注意你可以重复使用字典中的单词。
     示例 3：
     输入:
     s = "catsandog"
     wordDict = ["cats", "dog", "sand", "and", "cat"]
     输出:
     []
     */


    /**
     * 动态规划
     * 官方题解，会超时
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",wordDict));
    }

}
