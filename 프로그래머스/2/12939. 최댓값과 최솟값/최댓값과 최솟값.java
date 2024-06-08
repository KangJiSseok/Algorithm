import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        int value;
        while(st.hasMoreTokens()){
            value = Integer.parseInt(st.nextToken());
            max =Math.max(value, max);
            min =Math.min(value, min);
        }
        
        String answer = "";
        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);
        
        return answer;
    }
}