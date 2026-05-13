/*
    103. Binary Tree Zigzag Level Order Traversal
    Leetcode Link :- https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
*/


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean sign = true;
        
        while(!q.isEmpty()){
            
            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();

            while(size--> 0){
                TreeNode curr = q.remove();
                if(!sign){
                    list.addFirst(curr.val);
                    
                }
                else{
                    list.addLast(curr.val);
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            ans.add(list);
            sign = !sign;
        }


        return ans;
    }
}