package com.zhou.leetcore;

/**
 * @Description 合并K个排序链表
 * @Author xiaohu
 * @Date 2020/1/21 9:20
 */
public class Question23 {

    /**
     合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     示例:
     输入:
     [
       1->4->5,
       1->3->4,
       2->6
     ]
     输出: 1->1->2->3->4->4->5->6
     */

    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}