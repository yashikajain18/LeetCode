class Solution {
    public boolean isHappy(int n) {
       HashSet<Integer> set = new HashSet<>();
         while(true){
            n = sumSqDigits(n);
            if(n==1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
    }
    public int sumSqDigits(int n){
        int num=0;
        while(n!=0){
           num+=(n%10)*(n%10);
           n=n/10;
        }
        return num;
    }
}