class Solution {
   private void dfs (int num, int digit, int n, int k, List<Integer> numbers) {
        
        if (n == 0) {
            numbers.add (num);
            return;
        }
        if (digit + k <= 9) {
            dfs (num * 10 + (digit + k), digit + k, n - 1, k, numbers);
        }
        if (k != 0 && digit - k >= 0) {
            dfs (num * 10 + (digit - k), digit - k, n - 1, k, numbers);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> numbers = new ArrayList<> ();
        
        for (int num = 1; num < 10; num++) {
            dfs (num, num, n - 1, k, numbers);
        }
        
        int[] answer = new int[numbers.size ()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.get (i);
        }
        
        return answer;
    }
// public int[] numsSameConsecDiff(int n, int k) {
//     ArrayList<Integer> ans = new ArrayList<>();
    
//     for(int i = 1; i <= 9; i++){
//         dfs(n, k,  ans, 0, i);
//     }
    
//     int[] ret = new int[ans.size()];
//     for(int i = 0; i < ret.length; i++){
//         ret[i] = ans.get(i);
//     }
    
//     return ret;
// }

// public void dfs(int n, int k, ArrayList<Integer> ans, int curr, int digit){
//      if(n < 0) return;
    
//     if(n == 1){
//         curr = (curr*10)+digit;
//         if(!ans.contains(curr))
//         {
//             ans.add(curr);
//         }
//         return;
//     }
//      curr = (curr*10)+digit;
            
//     if(digit+k >=0 && digit+k <= 9){
//         dfs(n-1, k, ans, curr, digit+k);
//     }
    
//     if(digit-k >=0 && digit-k <= 9){
//         dfs(n-1, k, ans, curr, digit-k);
//      }
//    }
}   