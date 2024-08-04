import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[2];       
        
        Map<String,Integer> map = new HashMap<>();
        
        answer[0] = 0;
        answer[1] = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add(words[0]);
        map.put(words[0],1);
        
        int index = 0;
        for(int i=1; i< words.length; i++){
            if(list.get(index).charAt(list.get(index).length()-1) != words[i].charAt(0) ||
              map.get(words[i]) != null
              ){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
            map.put(words[i],1);
            list.add(words[i]);
            index++;
        }
        return answer;
    }
}