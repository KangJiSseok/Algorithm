import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        
        for(int i=0; i<moves.length; i++){
            int mv = moves[i] - 1;
            
            for(int j=0; j< board.length; j++){                
                if(board[j][mv] !=0 ){
                    //1. 스택이 비었을때
                    if(deque.isEmpty()){
                        deque.addLast(board[j][mv]);
                        board[j][mv] = 0;
                    }else{
                        //2. 스택이 안비었을때    
                        if(deque.peekLast() == board[j][mv]){
                            count += 2;
                            deque.pollLast();
                            board[j][mv] = 0;
                        }else{
                            deque.addLast(board[j][mv]);
                            board[j][mv] = 0;
                        }
                    }                    
                    break;
                }
            }
            
        }
        return count;
    }
}