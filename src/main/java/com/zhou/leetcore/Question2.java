package com.zhou.leetcore;

/**
 * @Description 两数相加
 *
 * @Author xiaohu
 * @Date 2020/1/16 9:34
 */
public class Question2 {


    /**
     *
     给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummyHead = new ListNode(0);
         ListNode p = l1, q = l2, curr = dummyHead;
         int carry = 0;
         while (p != null || q != null) {
            //两个链表的同一位赋值给变量x和y
             int x = (p != null) ? p.val : 0;
             int y = (q != null) ? q.val : 0;

             int sum = carry + x + y;
             carry = sum / 10; //这里的carry循环时在上面这个式子用int sum = carry + x + y;

             curr.next = new ListNode(sum % 10);  //如果结果是两位数，各位数留在结果链表里
             curr = curr.next;

             if (p != null) p = p.next;
             if (q != null) q = q.next;
         }

        //最后一位的进位，如果有进位，把进位放到下一个链表里
         if (carry > 0) {
         curr.next = new ListNode(carry);
         }
         return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(342);
        ListNode node2 = new ListNode(465);
        System.out.println(addTwoNumbers(node1,node2));
        System.out.println(addTwoNumbers2(node1,node2));
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }
    public static ListNode add(ListNode l1, ListNode l2,int z) {
        if(l1==null&&l2==null&&z==0){
            return null;
        }
        if(l1==null){
            l1=new ListNode(0);
        }
        if(l2==null){
            l2=new ListNode(0);
        }
        int value=l1.val+l2.val+z;
        ListNode result=new ListNode(value%10);
        result.next=add(l1.next, l2.next,value/10);
        return result;
    }


   private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}

