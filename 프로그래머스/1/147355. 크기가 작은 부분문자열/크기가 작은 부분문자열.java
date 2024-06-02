import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length =p.length();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i=0; i<= t.length() - length; i++){
            if(Long.parseLong(p) >= Long.parseLong(t.substring(i,length+i))){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}