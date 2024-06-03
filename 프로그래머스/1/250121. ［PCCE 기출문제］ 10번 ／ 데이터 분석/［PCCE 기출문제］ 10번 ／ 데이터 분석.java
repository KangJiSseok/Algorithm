import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by){
        
        HashMap<String,Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int getExt =map.get(ext);
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<data.length; i++){
            if(data[i][getExt] < val_ext){
                list.add(data[i]);
            } 
        }
        
        int search = map.get(sort_by);
        
        list.sort((v1,v2) -> v1[search] - v2[search]);
        
        int[][] answer = new int[list.size()][4];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}