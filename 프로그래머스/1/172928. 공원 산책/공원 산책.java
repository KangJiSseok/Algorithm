import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int colum = park.length;
        int row = park[0].length();
        
        int[][] location = new int[colum][row];
        
        
        
        int currentX =0; 
        int currentY =0; 
        
        for(int i=0; i<colum; i++){
            for(int j=0; j<row; j++){
                if(park[i].charAt(j) == 'S') {
                    currentY = i;
                    currentX = j;
                }
                else if(park[i].charAt(j) == 'X'){
                    location[i][j] = 1;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            String way = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            //장애물 설치 
            
            int eX =0;
            int eY =0;
            boolean a = true;
            switch(way) {
                case "E" :
                    if(currentX + value >=0 && currentX + value < row ){
                        a = true;
                        eX = currentX;
                        eY = currentY;
                        for(int k=0; k< value; k++){
                            if (location[eY][++eX] == 1){
                                a = false;
                                break;
                            }
                        }
                        if( a == true){
                            currentX += value;   
                        }
                    }
                    break;
                case "W" :                    
                    if(currentX - value >=0 && currentX - value < row ){
                        a = true;
                        eX = currentX;
                        eY = currentY;
                        for(int k=0; k< value; k++){
                            if (location[eY][--eX] == 1){
                                a = false;
                                break;
                            }
                        }
                        if( a == true){
                            currentX -= value;   
                        }
                    }
                    break;
                case "N" :
                    if(currentY - value >=0 && currentY - value < colum ){
                        a = true;
                        eX = currentX;
                        eY = currentY;
                        for(int k=0; k< value; k++){
                            if (location[--eY][eX] == 1){
                                a = false;
                                break;
                            }
                        }
                        if( a == true){
                            currentY -= value;   
                        }
                    }
                    break;
                case "S" :
                    if(currentY + value >=0 && currentY + value < colum ){
                        a = true;
                        eX = currentX;
                        eY = currentY;
                        for(int k=0; k< value; k++){
                            if (location[++eY][eX] == 1){
                                a = false;
                                break;
                            }
                        }
                        if( a == true){
                            currentY += value;   
                        }
                    }
                    break;
            }
        }
        
        
        int[] answer = {currentY, currentX};
        return answer;
    }
}