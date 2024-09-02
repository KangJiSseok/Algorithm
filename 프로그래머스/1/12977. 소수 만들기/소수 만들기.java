import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int result = 0;

        boolean[] numberList = new boolean[3000];
        Arrays.fill(numberList, true);
        numberList[0] = false;
        numberList[1] = false;

        for (int i = 2; i < 3000; i++) {
            
            if (!numberList[i]) continue;

            for (int j = i * 2; j < 3000; j += i) {
                numberList[j] = false;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k =  j + 1; k < nums.length; k++) {
                    if(numberList[nums[i] + nums[j] + nums[k]]){
                        result++;
                    }
                }
            }
        }

        return result;
    }
}