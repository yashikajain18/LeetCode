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
    int verticalIndex;
    int horizontalIndex;
    pair(TreeNode node,int verticalIndex,int horizontalIndex){
        this.node=node;
        this.verticalIndex=verticalIndex;
        this.horizontalIndex=horizontalIndex;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> t=new TreeMap<>();
        q.add(new pair(root,0,0));
        while(q.isEmpty()==false){
            pair p=q.poll();
            int v=p.verticalIndex;
            int h=p.horizontalIndex;
            TreeNode node=p.node;
            if(t.containsKey(v)==false){
                t.put(v,new TreeMap<>());
            }
            if(t.get(v).containsKey(h)==false){
                t.get(v).put(h,new PriorityQueue<>());
            }
            t.get(v).get(h).offer(node.val);
            if(node.left!=null) q.offer(new pair(node.left,v-1,h+1));
            if(node.right!=null) q.offer(new pair(node.right,v+1,h+1));
        }
        List<List<Integer>> l=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> k:t.values()){
            List<Integer> u=new ArrayList<>();
            for(PriorityQueue<Integer> pq:k.values()){
                while(pq.isEmpty()==false){
                    u.add(pq.poll());
                }
            }
            l.add(u);
        }
        return l;
    }
}

// class pair{
//     TreeNode node;
//     int hl;
//     pair(TreeNode node, int hl){
//         this.node=node;
//         this.hl=hl;
//     }
// }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>>ans=new ArrayList<>();
//         HashMap<Integer, List<Integer>> map=new HashMap<>();
//         Queue<pair> q=new LinkedList<>();
//         q.add(new pair(root, 0));
//         int maxhl=0;
//         int minhl=0;
//         while(!q.isEmpty()){
//             int size=q.size();
//             while(size-->0){
//                 pair p=q.remove();
//                 TreeNode node=p.node;
//                 int hl=p.hl;
//                 minhl=Math.min(hl, minhl);
//                 maxhl=Math.max(hl, maxhl);
//                 map.putIfAbsent(hl, new ArrayList<>());
//                 map.get(hl).add(node.val);
                
//                 if(node.left!=null){
//                     q.add(new pair(node.left, hl-1));
//                 }
//                 if(node.right!=null){
//                     q.add(new pair(node.right, hl+1));
//                 }
//             }
//         }
        
//         for(int i=minhl; i<=maxhl; i++){
//             ans.add(map.get(i));
//         }
//         return ans;
//     }
// }