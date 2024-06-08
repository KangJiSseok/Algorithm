import java.util.*;

class Solution{
    public int solution(String s){
        
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i=0; i< s.length(); i++){
            list.add(s.charAt(i));
            // System.out.println("put "+s.charAt(i));
            while(list.size() >=2 &&list.get(list.size() - 1) == list.get(list.size() - 2)){
                // System.out.println("remove "+list.get(list.size() -1 ));
                list.remove(list.size() - 1);
                // System.out.println("remove "+list.get(list.size() -1 ));
                list.remove(list.size() - 1);
            }
        }
        
        int answer = 0;
        if(list.size() == 0){
            answer = 1;
        }
        return answer;
    }
}