/*
    110. Balanced Binary Tree
    Leetcode Link :- https://leetcode.com/problems/balanced-binary-tree/description/
 */





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        if(left == -1) return -1;

        int right = solve(root.right);
        if(right == -1) return -1;

        int diff = Math.abs(left-right);
        if(diff > 1) return -1;

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }
}