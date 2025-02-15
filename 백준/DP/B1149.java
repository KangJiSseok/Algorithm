import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
	static int[] board = new int[3];
	static int[][] dp = new int[2][3];


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[j] = Integer.parseInt(st.nextToken());
			}

			dp[i % 2][0] = Math.min(dp[(i - 1) % 2][1], dp[(i - 1) % 2][2]) + board[0];
			dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][2]) + board[1];
			dp[i % 2][2] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]) + board[2];
		}

		System.out.println(Math.min(Math.min(dp[N % 2][0], dp[N % 2][1]), dp[N % 2][2]));
	}
}
