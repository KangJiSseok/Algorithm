import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> rank = new HashMap<>();
        
        for(int i=0; i< players.length; i++){
            name.put(players[i],i);
            rank.put(i,players[i]);
        }
        
        // 1. name에서 index 찾고
        // 2. rank에서 String찾고 
        // 3. name에서 찾은 index 찾고
        // 4. change
        
        for(int i=0; i< callings.length; i++){
            String backName = callings[i];
            //index
            int back=name.get(backName);
            
            String frontName=rank.get(back-1);
            
            //index
            int front = name.get(frontName);
            
            //change
            name.put(backName,back-1);
            name.put(frontName,back);
            rank.put(back-1,backName);
            rank.put(back,frontName);
        }
        
        String[] answer = new String[rank.size()];
            
        for(int i=0; i< rank.size(); i++){
            answer[i] = rank.get(i);
        }
        
        
        return answer;
    }
}