import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> deque = new LinkedList<>();
        
        for(int i=0; i< s.length(); i++){
            
            if(deque.isEmpty()){
                deque.addLast(s.charAt(i));    
                continue;
            }
            
            if(s.charAt(i) == '('){
                deque.addLast(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(deque.peek() == ')'){
                    deque.addLast(s.charAt(i));
                }else if(deque.peek() == '('){
                    deque.pollLast();
                }
            }            
        }
        
        boolean answer;
        if(deque.isEmpty()){
            answer = true;   
        }else{
            answer = false;   
        }
        
        return answer;
    }
}