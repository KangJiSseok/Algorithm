import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int zeroCount;
    static int oneCount;
    static int[] dp = new int[41];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Arrays.fill(dp, 0);
            int Zero = fibonacciZero(N);
            Arrays.fill(dp, 0);
            int One = fibonacciOne(N);
            sb.append(Zero).append(" ").append(One).append("\n");
        }

        System.out.println(sb.toString());
    }


    static int fibonacciZero(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fibonacciZero(n - 1) + fibonacciZero(n - 2);
    }

    static int fibonacciOne(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fibonacciOne(n - 1) + fibonacciOne(n - 2);
    }
}