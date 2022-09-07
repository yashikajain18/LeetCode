class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[]visited=new boolean[rooms.size()];
        bfs(rooms,visited,0);
        for(boolean b:visited){
            if(b==false) return false;
        }
        return true;
    }
    
    private void bfs(List<List<Integer>> rooms, boolean[]visited, int src){
        Queue<Integer>q = new LinkedList<>();
        q.add(src);
        visited[src]=true;
        int v=visited.length;
        while(!q.isEmpty()){
            int front=q.poll();
            for(int i:rooms.get(front)){
              if(visited[i]==false){
                   q.add(i); 
                   visited[i]=true;
              }
            }
        }
    }
}