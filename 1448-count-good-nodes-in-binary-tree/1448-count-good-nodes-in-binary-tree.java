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
    //int count=0;
    // public int dfs(TreeNode root, int[] max, int[]count){
    //      if(root==null) return 0;
    //      max[0]=Math.max(max[0], root.val);
    //      if(max[0]<=root.val) count[0]++;
    //      int l= dfs(root.left, max, count);
    //      int r= dfs(root.right, max, count);
    //      return count[0];
    // }
    // public int goodNodes(TreeNode root) {
    //   int max[]=new int[1];
    //   max[0]=root.val;
    //   int count[]=new int[1];
    //   count[0]=0;  
    //   return dfs(root,max, count);
    // }
    int count = 0; 

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count; 
    }

    private void helper(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) { 
                count++; 
            }
            helper(root.left, Math.max(root.val, max));  
            helper(root.right, Math.max(root.val, max));  
        }
    }
}