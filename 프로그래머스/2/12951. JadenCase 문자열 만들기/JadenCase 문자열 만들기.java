import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        // 1 = 49 , 9= 57
        // A = 65, Z = 90
        // 대문자 + 32 = 소문자 
        
        while(st.hasMoreTokens()){
            String text =st.nextToken();
            if(97<=text.charAt(0) && text.charAt(0)<=122){
                    sb.append((char)(text.charAt(0)-32));
            }else{
                sb.append((char)(text.charAt(0)));
            }
            
            for(int i=1; i< text.length(); i++){
                if(65<=text.charAt(i) && text.charAt(i)<=90){
                    sb.append((char)(text.charAt(i)+32));
                }else{
                    sb.append((char)(text.charAt(i)));
                }
            }
            
        }
        
        String answer = sb.toString();
        return answer;
    }
}