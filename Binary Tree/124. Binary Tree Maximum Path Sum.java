/*
    124. Binary Tree Maximum Path Sum
    Leetcode Link :- https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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
    int ans = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null) return 0;
            
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int leftPath = leftSum + root.val;
        int rightPath = rightSum + root.val;
        ans = Math.max(ans, Math.max(root.val, Math.max(root.val+leftSum+rightSum, Math.max(leftPath, rightPath))));

        return Math.max(root.val , Math.max(leftSum, rightSum) + root.val);
    }
    public int maxPathSum(TreeNode root){
        solve(root);
        return ans;
    }
}