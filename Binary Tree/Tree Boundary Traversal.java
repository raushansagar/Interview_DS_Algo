
/*
    Tree Boundary Traversal
    GFG Link :- https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
*/



/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/


class Solution {
    public boolean isLeaf(Node curr){
        return curr.left == null && curr.right == null;
    }
    public void collectLeft(Node curr, List<Integer> left){

        while(curr != null){
            
            if(!isLeaf(curr)) left.add(curr.data);
            
            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        
    }
    public void collectRight(Node curr, List<Integer> right){
        
        while(curr != null){
            
            if(!isLeaf(curr)) right.add(curr.data);
            
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        
    }
    public void collectButtom(Node curr, List<Integer> buttom){
        if(curr == null) return;
        
        if(isLeaf(curr)){
            buttom.add(curr.data);
            return;
        }
        
        collectButtom(curr.left, buttom);
        collectButtom(curr.right, buttom);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        List<Integer> left = new ArrayList<>();
        List<Integer> buttom = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        collectLeft(root.left, left);
        collectRight(root.right, right);
        collectButtom(root, buttom);
        
        if(!isLeaf(root)) ans.add(root.data);
        
        for(int val : left){
            ans.add(val);
        }
        for(int val : buttom){
            ans.add(val);
        }
        for(int i = right.size()-1; i >= 0; i--){
            ans.add(right.get(i));
        }
        
        return ans;
    }
}
