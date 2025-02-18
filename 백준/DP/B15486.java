import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15486 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		int[][] arr = new int[n + 2][2];
		int[] dp = new int[n + 2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i][0] = t; // 기간
			arr[i][1] = p; // 금액
		}

		int max = -1;
		for (int i = 1; i <= n + 1; i++) {
			max = Math.max(max, dp[i]);
			if (i + arr[i][0] <= n + 1) {
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
			}
		}
		System.out.println(dp[n + 1]);
	}
}
