class Solution {
    
    static long[] dpArr;
    public long solution(int n) {
        dpArr = new long[n+1];
        
        long answer = dp(n);
        return answer;
    }
    
    public long dp(int n){
        if(dpArr[n] != 0) return dpArr[n];
        if(n == 0) return 1;
        if(n == 1) return dp(n-1);
        return dpArr[n] = (dp(n-1) + dp(n-2)) % 1234567;
        
    }
}