class Solution {
    
    static int[] arr = new int[100001];
    
    public int solution(int n) {
        
        int answer = fivo(n);
        return answer;
    }
    
    public int fivo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(arr[n] != 0 ) return arr[n];
        return (fivo(n-1) + fivo(n-2)) % 1234567;
    }
}