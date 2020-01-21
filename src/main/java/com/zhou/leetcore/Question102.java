package com.zhou.leetcore;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * @Description 二叉树的层次遍历
 * @Author xiaohu
 * @Date 2020/1/21 9:28
 */
public class Question102 {

    /**
     给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     例如:
     给定二叉树: [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     返回其层次遍历结果：
     [
     [3],
     [9,20],
     [15,7]
     ]
     */

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
