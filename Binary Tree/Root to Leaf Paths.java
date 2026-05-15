/*
    Root to Leaf Paths
    GFG Link :- https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
 */



/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void solve(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(root == null) return;
         list.add(root.data);
         
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        
        solve(root.left, list, ans);
        solve(root.right, list, ans);
        
        list.remove(list.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        solve(root, new ArrayList<>(), ans);
        return ans;
    }
}