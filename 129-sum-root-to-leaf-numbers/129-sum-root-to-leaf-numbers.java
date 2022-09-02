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
    int ans=0;
    
    private void dfs(TreeNode root, int s){
        if(root == null) return;
        
        s = s*10 + root.val;
        
        if(root.left == null && root.right == null){
            ans += s;
        }
        
        dfs(root.left, s);
        dfs(root.right, s);
    }
    public int sumNumbers(TreeNode root) {
       
        dfs(root,0);
        return ans;
    }
}

// int ans=0;
    
//     private void dfs(TreeNode root, String s){
//         if(root==null) return;
       
//         if(root.left==null&&root.right==null){
//             ans+=Integer.parseInt(s+root.val,10);
//             return;    
//         }
//         s+=root.val;
//         dfs(root.left,s);
//         dfs(root.right,s);
//         return;
//     }
//     public int sumNumbers(TreeNode root) {
       
//         dfs(root, "");
//         return ans;
//     }