class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[]visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]==false){
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
   
    
    private void bfs(int[][]graph, boolean[]visited, int src){
        Queue<Integer> q=new LinkedList<>();
        int v=visited.length;
        q.add(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int rp=q.poll();
            for(int i=0; i<v; i++){
                if(graph[rp][i]==1&&visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                } 
            }
        }
    }
}