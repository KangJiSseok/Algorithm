import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp = new int[2][1001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String compareText = br.readLine();

        int index = 0;

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= compareText.length(); j++) {
                if (text.charAt(i - 1) == compareText.charAt(j - 1)) {
                    dp[index][j] = dp[index^1][j - 1] + 1;
                } else {
                    dp[index][j] = Math.max(dp[index^1][j], dp[index][j - 1]);
                }
            }
            index ^= 1;
        }

        System.out.println(dp[index^1][compareText.length()]);

    }
}