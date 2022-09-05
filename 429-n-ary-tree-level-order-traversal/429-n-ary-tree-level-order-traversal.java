/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> arr=new ArrayList<>();
            while(size-->0){
                Node front=q.poll();
                arr.add(front.val);
                for(Node n: front.children){
                    if(n!=null) q.add(n);
                }
            }
            ans.add(arr);
        }
        return ans;
    }
}