package com.zhou.leetcore;

import java.util.List;

/**
 * @Description 二叉树的锯齿形层次遍历
 * @Author xiaohu
 * @Date 2020/1/21 9:28
 */
public class Question103 {

    /**
     给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     例如：
     给定二叉树 [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     返回锯齿形层次遍历如下：
     [
     [3],
     [20,9],
     [15,7]
     ]
     */

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
