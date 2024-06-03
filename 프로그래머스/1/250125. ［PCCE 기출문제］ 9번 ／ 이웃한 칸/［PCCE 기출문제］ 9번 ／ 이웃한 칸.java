import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    static int[] dh = {0,1,-1,0};
    static int[] dw = {1,0,0,-1};
    
    public int solution(String[][] board, int h, int w) {
        
        int boardLength = board.length;
        
        int answer = 0;
        for(int i=0; i<4; i++){
            if(dh[i] + h >=0 && dh[i] + h <boardLength && 
               dw[i] + w >=0 && dw[i] + w <boardLength){
                if(board[h][w].equals(board[dh[i] + h][dw[i] + w])) answer++;
            }
        }
        
        return answer;
    }
}