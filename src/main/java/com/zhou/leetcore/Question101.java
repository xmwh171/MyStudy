package com.zhou.leetcore;

/**
 * @Description 对称二叉树
 * @Author xiaohu
 * @Date 2020/1/21 9:27
 */
public class Question101 {

    /**
     给定一个二叉树，检查它是否是镜像对称的。
     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     1
     / \
     2   2
     / \ / \
     3  4 4  3
     但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     1
     / \
     2   2
     \   \
     3    3
     说明:
     如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     */

    /**
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return false;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}