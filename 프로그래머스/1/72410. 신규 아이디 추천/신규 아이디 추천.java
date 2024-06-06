import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        //1단계
        char[] id = new char[new_id.length()];
        
        for(int i=0; i<new_id.length(); i++){
            if(65<=new_id.charAt(i) && new_id.charAt(i) <= 90){
                id[i] = (char)(new_id.charAt(i) + 32);
            }else{
                id[i] = new_id.charAt(i);
            }
        }
        
        
        //2단계
        String two = "";
        
        for(int i=0; i<id.length; i++){
            two += id[i];
        }
        two = two.replaceAll("[^-_.a-z0-9]","");
        
        System.out.println(two);
        
        //3단계 
        while(two.contains("..")){
            two = two.replace("..",".");
        }
        String three = two;
        System.out.println(three);
        
        //4단계        
        String four;
        if(three.length() > 0){
            if(three.charAt(0)=='.'){
                three = three.substring(1,three.length());
            }    
        }
        if(three.length() > 0){
            if(three.charAt(three.length()-1) == '.'){
                three = three.substring(0,three.length()-1);
            }
        }
        four = three;
        System.out.println(four);
        
        //5단계
        if(four.length() == 0){
            four += "a";
        }
        String five = four;
        System.out.println(five);
        
        //6단계
        if(five.length() >=16){
            five = five.substring(0,15);
            if(five.charAt(five.length()-1) =='.'){
                five = five.substring(0, five.length()-1);
            }
        }
        String six = five;
        System.out.println(six);
        
        //7단계
        if(six.length() <=2){
            while(!(six.length() == 3)){
                six+= String.valueOf(six.charAt(six.length()-1));
            }
        }
        String seven = six;
        System.out.println(seven);
        
        String answer = seven;
        return answer;
    }
}