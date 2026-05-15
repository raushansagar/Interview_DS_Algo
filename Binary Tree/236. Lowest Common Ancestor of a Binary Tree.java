/*
    236. Lowest Common Ancestor of a Binary Tree
    Leetcode Link :- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public void findAncestor(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(root == null) return;

        map.put(root, parent);
        findAncestor(root.left, root, map);
        findAncestor(root.right, root, map);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        
        findAncestor(root, new TreeNode(Integer.MAX_VALUE), map);

        while(map.containsKey(p)){
            set.add(p);

            TreeNode parent = map.get(p);
            p = parent;
        }
        if(set.contains(q)) return q;


        while(map.containsKey(q)){
            if(set.contains(q)) return q;

            TreeNode parent = map.get(q);
            q = parent;
        }

        return p;
    }
}