import java.util.*;

class Solution {
    public int solution(int n) {
        int nCount = 0;
        String nBinary = Integer.toBinaryString(n);
        
        for(int i=0; i< nBinary.length(); i++){
            if(nBinary.charAt(i) == '1'){
                nCount++;
            }
        }
        
        int searchCount = -1;
        int search = n;
        String searchBinary;
        
        while(searchCount != nCount){
            searchCount = 0;
            searchBinary = Integer.toBinaryString(++search);
            for(int i=0; i< searchBinary.length(); i++){
                if(searchBinary.charAt(i) == '1'){
                    searchCount++;
                }
            }            
        }
        
        // System.out.println(search);
        
        int answer = search;
        return answer;
    }
}