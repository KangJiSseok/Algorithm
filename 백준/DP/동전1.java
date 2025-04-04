import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class 동전1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= k; i++) {
				dp[i] = dp[i] + dp[i - coin];
			}
		}

		System.out.println(dp[k]);
	}
}

/**
 *
 *  1,2,5
 *	0	1	2	3	4	5	6	7	8	9	10
 * 	1	1	1	1	1	1	1	1	1	1	1
 *	1	1	2	2	3	3	4	4	5	5	6
 *	1	1	2	2	3	4	5	6	7	8	10
 */
