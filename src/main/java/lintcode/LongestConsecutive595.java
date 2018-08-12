/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: LongestConsecutive595.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午5:36
 * Version: 1.0.0
 * LastModified: 18-8-12 下午5:36
 */

package lintcode;

import lintcode.pojo.TreeNode;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午5:36
 */
public class LongestConsecutive595 {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        return longestDFS(root, null, 0);
    }

    public int longestDFS(TreeNode treeNode, TreeNode parentNode, int length){
        if (treeNode == null){
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null && treeNode.val > parentNode.val){
            return 1;
        }
        int leftCount = (treeNode.left != null && treeNode.left.val > treeNode.val)? longestConsecutive(treeNode.left) : 0;
        int rightCount = (treeNode.right != null && treeNode.right.val > treeNode.val)? longestConsecutive(treeNode.right) : 0;
        return 1 + Math.max(leftCount,rightCount);
    }


    /**
     * 参考解法一
     * @param root
     * @return
     */
    public int longestConsecutive_1(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }

        int length = (parent != null && parent.val + 1 == root.val) ? lengthWithoutRoot + 1 : 1;
        int left = dfs(root.left, root, length);
        int right = dfs(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }

    /**
     * ######################
     */
}
