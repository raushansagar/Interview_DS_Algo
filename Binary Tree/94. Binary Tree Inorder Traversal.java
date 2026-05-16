/*
    94. Binary Tree Inorder Traversal
    leetcode link :- 
 */



// Approch 1

// Recursive traversal

// Time Complexity O(n)
// Stack Space Complexity O(n)

class Solution {
    public void solve(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }

        solve(root.left, ans);

        ans.add(root.val);
        
        solve(root.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, ans);
        return ans;
    }
}



// Morris Traversal

// Time Complexity O(n)
// Stack Space Complexity O(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode curr) {
        List<Integer> ans = new ArrayList<>();
        if(curr == null) return ans;

        while(curr != null){

            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode leftChild = curr.left;

                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;

                // delete node
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return ans;
    }
}
