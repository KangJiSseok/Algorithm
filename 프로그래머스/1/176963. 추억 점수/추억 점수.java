import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String,Integer> map = new HashMap<>();
        
        ArrayList<Integer> resultArray = new ArrayList<>();
        
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        
        for(int i=0; i< photo.length; i++){
            int resultValue = 0;
            for(int j=0; j< photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    resultValue+=map.get(photo[i][j]);
                }
            }
            resultArray.add(resultValue);
        }
        
        return resultArray.stream().mapToInt(Integer -> Integer).toArray();
    }
}