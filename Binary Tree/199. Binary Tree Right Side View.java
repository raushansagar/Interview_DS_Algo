/*
    199. Binary Tree Right Side View
    Leetcode Link :- https://leetcode.com/problems/binary-tree-right-side-view/description/
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();

            while(size--> 0){
                TreeNode curr = q.remove();
                list.addLast(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(list.size() == 1){
                ans.add(list.getFirst());
            }
            else{
                ans.add(list.getLast());
            }
        }


        return ans;
    }
}