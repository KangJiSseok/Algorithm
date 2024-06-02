import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        HashMap<String,Integer> map = new HashMap<>();
        int privaciesLen = privacies.length;
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[][] privaciesList = new int[privaciesLen][4];
        
        StringTokenizer st = new StringTokenizer(today,".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());    
        
        int current = 12*28*year + 28*month + date;
        
        for(int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0; i<privaciesLen; i++){
            st = new StringTokenizer(privacies[i]," .");
            int getYear = Integer.parseInt(st.nextToken());
            int getMonth = Integer.parseInt(st.nextToken());
            int getDate = Integer.parseInt(st.nextToken());
            int term = map.get(st.nextToken());
            
            int before = 12*28*getYear + 28*getMonth + getDate + 28*term;
            
            if(current >= before){
                answer.add(i + 1);
            }
            
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}