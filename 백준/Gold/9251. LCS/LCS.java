import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String compareText = br.readLine();

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= compareText.length(); j++) {
                if (text.charAt(i - 1) == compareText.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[text.length()][compareText.length()]);

    }
}