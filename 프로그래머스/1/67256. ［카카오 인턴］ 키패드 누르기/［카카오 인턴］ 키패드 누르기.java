import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] phone = new int[4][3];
        
        HashMap<Integer, Integer[]> map = new HashMap<>();
        map.put(1,new Integer[]{0,0});
        map.put(2,new Integer[]{0,1});
        map.put(3,new Integer[]{0,2});
        map.put(4,new Integer[]{1,0});
        map.put(5,new Integer[]{1,1});
        map.put(6,new Integer[]{1,2});
        map.put(7,new Integer[]{2,0});
        map.put(8,new Integer[]{2,1});
        map.put(9,new Integer[]{2,2});
        map.put(0,new Integer[]{3,1});
        
        int leftY = 3;
        int leftX = 0;
        int rightY = 3;
        int rightX = 2;
        
        for(int i=0; i<numbers.length; i++){
            int y = map.get(numbers[i])[0];
            int x = map.get(numbers[i])[1];
            
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                leftY = y;
                leftX = x;
                sb.append("L");
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rightY = y;
                rightX = x;
                sb.append("R");
            }else{
                int leftValue = Math.abs(leftY-y) + Math.abs(leftX-x);
                int rightValue = Math.abs(rightY-y) + Math.abs(rightX-x);
                
                if(leftValue > rightValue){
                    rightY = y;
                    rightX = x;
                    sb.append("R");
                }else if(leftValue < rightValue){
                    leftY = y;
                    leftX = x;
                    sb.append("L");
                }else{
                    if(hand.equals("left")){
                        leftY = y;
                        leftX = x;
                        sb.append("L");
                    }else{
                        rightY =y;
                        rightX =x;
                        sb.append("R");
                    }
                }                
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}