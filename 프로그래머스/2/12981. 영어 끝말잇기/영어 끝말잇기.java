import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[2];                
        answer[0] = 0;
        answer[1] = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add(words[0]);
        
        int index = 0;
        for(int i=1; i< words.length; i++){
            if(list.get(index).charAt(list.get(index).length()-1) != words[i].charAt(0) 
                || list.contains(words[i])
              ){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
            list.add(words[i]);
            index++;
        }
        return answer;
    }
}