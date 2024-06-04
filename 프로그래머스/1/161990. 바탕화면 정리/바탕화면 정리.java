import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int column = wallpaper.length;
        int row = wallpaper[0].length();
        
        int minX =100;
        int maxX =0;
        int minY =100;
        int maxY =0;
        
        // System.out.println(column);
        // System.out.println(row);
        
        int[][] graph = new int[column][row];
        
        for(int i=0; i< column; i++){
            for(int j=0; j< row; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    graph[i][j] = 1;
                }
            }
        }
        
        // for(int i=0; i< column; i++){
        //     System.out.println();
        //     for(int j=0; j< row; j++){
        //         System.out.print(graph[i][j]);
        //     }
        // }
        
        
        
        for(int i=0; i< column; i++){
            System.out.println();
            for(int j=0; j< row; j++){
                System.out.print(graph[i][j]);
            }
        }
        
        
        for(int i=0; i< column; i++){
            
            for(int j=0; j< row; j++){
                if(graph[i][j] == 1){
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        
//         System.out.println();
//         System.out.println(minY);
//         System.out.println(minX);
//         System.out.println(maxY+1);
//         System.out.println(maxX+1);
        
        
        
        int[] answer = new int[4];
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY+1;
        answer[3] = maxX+1;
        
        return answer;
    }
}