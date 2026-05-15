
/*
    Children Sum in a Binary Tree
    GFG Link :- https://www.geeksforgeeks.org/problems/children-sum-parent/1
*/



/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/


class Solution {
    public int solve(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        
        int left = solve(root.left);
        int right = solve(root.right);

        if(left == -1 || right == -1 || root.data != left+right) return -1;
        
        return root.data;
    }
    public boolean isSumProperty(Node root) {
        return solve(root) >= 0 ? true : false;
    }
}