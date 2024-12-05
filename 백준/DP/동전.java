import java.util.*;
import java.io.*;

public class 동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] money = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                money[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][M + 1];

            for (int j = 0; j <= N; j++) {
                dp[j][0] = 1;
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    dp[j][k] = dp[j - 1][k];
                    if (k - money[j - 1] >= 0) {
                        dp[j][k] += dp[j][k - money[j - 1]];
                    }
                }
            }

            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
