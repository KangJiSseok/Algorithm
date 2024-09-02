import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        String answer = null;
        
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) != null) {
                map.put(participant[i], map.get(participant[i]) + 1);
            }else{
                map.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
             int remainValue = map.get(completion[i]) - 1;
             if(remainValue == 0){
                 map.remove(completion[i]);
             }else{
                 map.put(completion[i], map.get(completion[i]) - 1);
             }
        }

        for (String s : map.keySet()) {
            answer = s;
        }
        
        return answer;
    }
}