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
    public static int height(TreeNode root, int max[]){
         if(root==null) return 0;
         int lh=height(root.left,max);
         int rh=height(root.right,max);
         max[0]=Math.max(max[0], lh+rh);
         return Math.max(lh,rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
       int max[]=new int[1];
       height(root,max);
       return max[0];   
    }
}