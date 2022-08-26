
///User function Template for Java

class pair{
    Node node;
    int hl;
    pair(Node node, int hl){
        this.node=node;
        this.hl=hl;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root, 0));
        int maxhl=0;
        int minhl=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair p=q.remove();
                Node node=p.node;
                int hl=p.hl;
                minhl=Math.min(hl, minhl);
                maxhl=Math.max(hl, maxhl);
                map.put(hl, node.data);
                
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