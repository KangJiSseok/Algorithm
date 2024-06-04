import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int listLen = id_list.length;
        int[][] graph = new int[listLen][listLen];
            
        HashMap<String, Integer> idToIndex = new HashMap<>();
        HashMap<Integer, String> indexToId = new HashMap<>();
        
        for(int i=0; i< listLen; i++){
            idToIndex.put(id_list[i], i);
            indexToId.put(i,id_list[i]);
        }
        
        for(int i=0; i< report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            int userId= idToIndex.get(st.nextToken());
            int targetId= idToIndex.get(st.nextToken());
            
            if(graph[userId][targetId]==0){
                graph[userId][targetId] = 1;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<listLen; i++){
            int count =0; 
            for(int j=0; j<listLen; j++){
                count += graph[j][i];
            }
            if(count >= k) {
                list.add(i);
                // System.out.println(indexToId.get(i));
            }
        }
        
        int[] answer = new int[listLen];
        for(int i=0; i<listLen; i++){
            int count =0; 
            for(int j=0; j<list.size(); j++){
                int index=list.get(j);
                if (graph[i][index] == 1) count ++;
            }
            answer[i] = count;
        }
        
        return answer;
    }
}