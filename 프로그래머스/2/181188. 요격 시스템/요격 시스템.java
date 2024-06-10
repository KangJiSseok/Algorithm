import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        
        Arrays.sort(targets, (o1, o2) -> 
                    {
                        return o1[1] - o2[1];
                    });
        
        // for(int i=0; i< targets.length; i++){
        //     for(int j=0; j<targets[0].length; j++){
        //         System.out.print(targets[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        // 1 끝점 < 2시작점
        
        //start
        int tail = targets[0][0];
        int head = targets[0][1];
        int result = 1;
        
        for(int i=1; i< targets.length; i++){
            int currentTail = targets[i][0];
            int currentHead = targets[i][1];
            
            if(head <= currentTail){
                tail = currentTail;
                head = currentHead;
                result++;
                // System.out.print(i + " ");
            }
            
        }
        
        return result;
    }
}