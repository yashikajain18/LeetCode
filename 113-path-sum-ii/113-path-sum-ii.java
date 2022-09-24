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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>path=new ArrayList<>();
        pathSumHelper(root, targetSum, ans, path);
        return ans;
    }
     public void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>>ans, ArrayList<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        if(targetSum==root.val && root.left==null && root.right==null){
            ans.add(new ArrayList<Integer>(path));
        }
         pathSumHelper(root.left, targetSum-root.val, ans, path);
         pathSumHelper(root.right, targetSum-root.val, ans, path);
         
         path.remove(path.size()-1);
         
     }
}