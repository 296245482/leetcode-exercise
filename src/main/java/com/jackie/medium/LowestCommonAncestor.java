package com.jackie.medium;

import com.jackie.datastructures.TreeNode;

/**
 * LeetCode-236
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class LowestCommonAncestor {

    private TreeNode ans = null;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean checkLeft = dfs(root.left, p, q);
        boolean checkRight = dfs(root.right, p, q);
        if ((checkLeft && checkRight) || ((root.val == p.val || root.val == q.val) && (checkRight || checkLeft))) {
            ans = root;
        }
        return checkRight || checkLeft || (root.val == p.val || root.val == q.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
