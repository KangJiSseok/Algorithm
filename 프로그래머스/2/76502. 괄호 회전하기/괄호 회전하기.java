import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        ArrayList<Character> c = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            c.add(s.charAt(i));
        }
        
        
        for(int i=0; i<s.length(); i++){
            Deque<Character> deque = new LinkedList<>();
            
            for(int j=0; j<s.length(); j++){
                char tmp = c.get(j);
                if(!deque.isEmpty() && tmp == ']' && deque.peekLast()=='['){
                    deque.pollLast();
                }
                else if(!deque.isEmpty() && tmp == ')' && deque.peekLast()=='('){
                    deque.pollLast();
                }
                else if(!deque.isEmpty() && tmp == '}' && deque.peekLast()=='{'){
                    deque.pollLast();
                }else{
                    deque.addLast(tmp);
                }
            }
            
            if(deque.size() ==0 ){
                answer++;
            }
            
            Collections.rotate(c,-1);
        }

        return answer;
    }
}