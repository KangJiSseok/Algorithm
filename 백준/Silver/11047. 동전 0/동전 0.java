import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int sum = 0;
    static int sum1 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int division;
        int sum = 0;
        for (int i = money.length - 1; i >= 0; i--) {
            if (money[i] <= K) {
                division = K / money[i];
                K = K % money[i];
                sum += division;
            }
        }

        System.out.println(sum);
    }
}

