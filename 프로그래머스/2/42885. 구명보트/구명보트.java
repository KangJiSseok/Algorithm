import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        int tail = 0;
        int head = people.length - 1;
        while(tail <= head){
            int sum = people[tail] + people[head];
            if(sum <= limit){
                tail++;
                head--;
                answer++;
            }
            else{
                head--;
                answer++;
            }
        }
        return answer;
    }
}