
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


class pair{
    TreeNode node;
    int hl;
    pair(TreeNode node, int hl){
        this.node=node;
        this.hl=hl;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root, 0));
        int maxhl=0;
        int minhl=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair p=q.remove();
                TreeNode node=p.node;
                int hl=p.hl;
                minhl=Math.min(hl, minhl);
                maxhl=Math.max(hl, maxhl);
                map.putIfAbsent(hl, new ArrayList<>());
                map.get(hl).add(node.val);
                
                if(node.left!=null){
                    q.add(new pair(node.left, hl-1));
                }
                if(node.right!=null){
                    q.add(new pair(node.right, hl+1));
                }
            }
        }
        
        for(int i=minhl; i<=maxhl; i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}