package com.jackie.medium;

import com.jackie.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class BuildTree {

    Map<Integer, Integer> inOrderMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int inOrderIndex = inOrderMap.get(preorder[preStart]);
        int gap = inOrderIndex - inStart + 1;
        treeNode.left = buildTreeNode(preorder, preStart + 1, preStart + gap - 1, inorder, inStart, inOrderIndex - 1);
        treeNode.right = buildTreeNode(preorder, preStart + gap, preEnd, inorder, inOrderIndex + 1, inEnd);
        return treeNode;
    }
}
