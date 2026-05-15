/*
    662. Maximum Width of Binary Tree
    Leetcode Link :- https://leetcode.com/problems/maximum-width-of-binary-tree/description/
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
    static class Pair{
        TreeNode root;
        int idx;

        Pair(TreeNode root, int idx){
            this.root = root;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 1;

        int width = 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Pair> list = new LinkedList<>();

            while(size--> 0){
                Pair p = q.remove();

                TreeNode curr = p.root;
                int idx = p.idx;
                list.add(p);

                if(curr.left != null){
                    q.add(new Pair(curr.left, (2*idx+1)));
                }
                if(curr.right != null){
                    q.add(new Pair(curr.right, (2*idx+2)));
                }
            }

            if(list.size() == 1){
                width = Math.max(width, 1);
            }
            else{
                Pair si = list.removeFirst();
                Pair ei = list.removeLast();

                width = Math.max(width, (ei.idx - si.idx + 1));
            }
        }


        return width;
    }
}