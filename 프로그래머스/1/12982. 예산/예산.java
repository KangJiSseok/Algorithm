import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;

        Arrays.sort(d);
        int i = 0;
        while (budget > 0 && i< d.length) {

            if(budget - d[i] < 0 ){
                break;
            }

            budget -= d[i];
            count++;
            i++;
        }

        return count;
    }
}