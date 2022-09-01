/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void parentChild(TreeNode root, HashMap<TreeNode, TreeNode>map){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            if(temp.left!=null) {
                map.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right!=null) {
                map.put(temp.right, temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       HashMap<TreeNode, TreeNode> map=new HashMap<>();
       parentChild(root, map);
       HashMap<TreeNode, Boolean> visited =new HashMap<>();
       Queue<TreeNode> q=new LinkedList<>();
       q.add(target);
       visited.put(target, true);
       int count=0;
       while(!q.isEmpty()){
           int size=q.size();
           if(count==k)break;
           count++;
           while(size-->0){
               TreeNode temp=q.remove();
               if(temp.left!=null && visited.get(temp.left)==null){
                   q.add(temp.left);
                   visited.put(temp.left, true);
               }
               if(temp.right!=null && visited.get(temp.right)==null){
                   q.add(temp.right);
                   visited.put(temp.right, true);
               }
               if(map.containsKey(temp)==true && visited.get(map.get(temp))==null){
                   q.add(map.get(temp));
                   visited.put(map.get(temp), true);
               }   
           }
        
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;          
    }
}