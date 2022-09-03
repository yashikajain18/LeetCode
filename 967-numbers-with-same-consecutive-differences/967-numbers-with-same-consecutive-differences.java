class Solution {

public int[] numsSameConsecDiff(int n, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    
    for(int i = 1; i <= 9; i++){
        dfs(n, k,  ans, 0, i);
    }
    
    int[] ret = new int[ans.size()];
    for(int i = 0; i < ret.length; i++){
        ret[i] = ans.get(i);
    }
    
    return ret;
}

public void dfs(int n, int k, ArrayList<Integer> ans, int curr, int digit){
     if(n < 0) return;
    
    if(n == 1){
        curr = (curr*10)+digit;
        if(!ans.contains(curr))
        {
            ans.add(curr);
        }
        return;
    }
     curr = (curr*10)+digit;
            
    if(digit+k >=0 && digit+k <= 9){
        dfs(n-1, k, ans, curr, digit+k);
    }
    
    if(digit-k >=0 && digit-k <= 9){
        dfs(n-1, k, ans, curr, digit-k);
     }
   }
}   