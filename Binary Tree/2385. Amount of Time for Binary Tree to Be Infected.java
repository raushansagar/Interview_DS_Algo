/*
    2385. Amount of Time for Binary Tree to Be Infected
    Leetcode Link :- https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
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
    TreeNode start = null;
    public void findAncestor(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map, int target){
        if(root == null) return;

        if(target == root.val) start = root;
        map.put(root, parent);

        findAncestor(root.left, root, map, target);
        findAncestor(root.right, root, map, target);
    }
    public int amountOfTime(TreeNode root, int target) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode parent = new TreeNode(-1);
        findAncestor(root, parent, map, target);

        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        set.add(parent);
        q.add(start);
        int minute = -2;
        
        while(!q.isEmpty()){
            int size = q.size();

            while(size--> 0){

                TreeNode curr = q.remove();
                if(set.contains(curr)) continue;
                set.add(curr);
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(map.containsKey(curr)) q.add(map.get(curr));
            }

            minute++;
        }


        return minute;
    }
}