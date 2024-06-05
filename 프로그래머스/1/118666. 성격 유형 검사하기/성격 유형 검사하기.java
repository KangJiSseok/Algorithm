import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character,Integer> mbti = new HashMap<>();
        mbti.put('R',1);
        mbti.put('T',2);
        mbti.put('C',3);
        mbti.put('F',4);
        mbti.put('J',5);
        mbti.put('M',6);
        mbti.put('A',7);
        mbti.put('N',8);
        
        HashMap<Integer,String> aaa = new HashMap<>();
        aaa.put(1,"R");
        aaa.put(2,"T");
        aaa.put(3,"C");
        aaa.put(4,"F");
        aaa.put(5,"J");
        aaa.put(6,"M");
        aaa.put(7,"A");
        aaa.put(8,"N");
        
        
        int[] mbtiValue = new int[9];
        
        for(int i=0; i< choices.length; i++){
            char a =survey[i].charAt(0);
            char b =survey[i].charAt(1);
            int one = mbti.get(a);
            int two = mbti.get(b);
            
            if (choices[i] == 1){
                mbtiValue[one] +=3;
            }else if(choices[i] == 2){
                mbtiValue[one] +=2;
            }else if(choices[i] == 3){
                mbtiValue[one] +=1;
            }else if(choices[i] == 4){
                continue;
            }else if(choices[i] == 5){
                mbtiValue[two] +=1;
            }else if(choices[i] == 6){
                mbtiValue[two] +=2;
            }else if(choices[i] == 7){
                mbtiValue[two] +=3;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=4; i++){
            if(mbtiValue[2*i-1] >= mbtiValue[2*i]){
                sb.append(aaa.get(2*i-1));
            }else{
                sb.append(aaa.get(2*i));
            }
        }
        
        
        
        return sb.toString();
    }
}