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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int size= q.size();
            count++;
            ArrayList<Integer> res=new ArrayList<>();
            while(size-->0){
               TreeNode node=q.remove(); 
               if(node.left!=null)q.add(node.left);
               if(node.right!=null)q.add(node.right);
               if(count % 2 != 0)
                   res.add(node.val);
                else
                    res.add(0,node.val);
            }
            ans.add(res);
        }
        return ans;
    }
}

 