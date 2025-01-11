public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        int[] arr = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                arr[j]++;
            }
        }

        for(int i = 1; i <= number; i++) {
            if(arr[i] > limit) {
                answer += power;
            } else {
                answer += arr[i];
            }
        }

        return answer;
    }
}
