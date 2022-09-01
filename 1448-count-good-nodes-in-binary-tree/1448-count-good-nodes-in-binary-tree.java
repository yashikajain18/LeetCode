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
    int count=0;
    public int dfs(TreeNode root, int max, int[]count){
         if(root==null) return 0;
         max=Math.max(max, root.val);
         if(max<=root.val) count[0]++;
         int l= dfs(root.left, max, count);
         int r= dfs(root.right, max, count);
         return count[0];
    }
    public int goodNodes(TreeNode root) {
       
    
      int count[]=new int[1];
      count[0]=0;  
      return dfs(root,root.val, count);
    }

}