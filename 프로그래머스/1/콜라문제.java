public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int remainder = n % a;
            int div = n / a;

            answer += div * b;
            n = remainder + div * b;
        }

        return answer;
    }
}
