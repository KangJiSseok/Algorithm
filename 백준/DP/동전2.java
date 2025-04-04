import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class 동전2 {
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
		Arrays.fill(dp, 10000000);
		dp[0] = 0;

		for (int coin : coins) {
			for (int i = coin; i <= k; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		if (dp[k] == 10000000) {
			System.out.println(-1);

		}else{
			System.out.println(dp[k]);
		}

	}
}

/**
 *
 * 	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
 * 	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
 * 						1	2	3	4	5	2	3	4	5	6	3
 * 																1
 *
 */