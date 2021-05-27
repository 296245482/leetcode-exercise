package com.jackie.medium;


import com.jackie.datastructures.TreeNode;

/**
 * 从前序和中序遍历重构二叉树
 *
 * 递归法
 *
 * @author Long Cheng
 * @date 2021/3/13.
 */
public class RebuildBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length -1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i ++) {
            if (pre[preStart] == in[i]) {
                treeNode.setLeft(build(pre, preStart + 1, preStart - inStart + i, in, inStart, i -1));
                treeNode.setRight(build(pre, preStart - inStart + i + 1, preEnd, in, i+1, inEnd));
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {

    }
}
