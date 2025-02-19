import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11066 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}


			// 구간합 구하기
			int[][] pSum = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j++) {
					pSum[i][j] = arr[j] + pSum[i][j - 1];
				}
			}
			for(int i = 1; i<= N; i++){
				pSum[i][i] = 0;
			}

			int[][] dp = new int[N+1][N+1];

			for (int k = 1; k < N; k++) {
				for (int i = 1; i <= N - k; i++) {
					int j = i + k;
					dp[i][j] = Integer.MAX_VALUE;

					//i <= x < j
					for (int x = i; x < j; x++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x + 1][j] + pSum[i][j]);
					}
				}
			}

			sb.append(dp[1][N]).append("\n");
		}

		System.out.print(sb);
	}
}



/**
 *
 * ~~~ 구간합 테이블 ~~~
 * 0	0	40	30	30	50	20
 * 0	0	1	2	3	4	5
 * 40	1		70	100	150	170
 * 30	2			60	110	130
 * 30	3				80	100
 * 50	4					70
 * 20	5
 *
 * ~~~ DP 테이블 ~~~
 * 1) 2개짜리 구간
 * 0	0	40	30	30	50	20
 * 0	0	1	2	3	4	5
 * 40	1	0	70	160	300
 * 30	2	0	0	60	170	260
 * 30	3	0	0	0	80	170
 * 50	4	0	0	0	0	70
 * 20	5	0	0	0	0	0
 *
 * 2) 3개짜리 구간
 *
 * [1~3] => (40, 30, 30)
 * - 분할구간
 * k = 1 (40 | 30, 30)
 * 0 + 60 + S(1,3) = 160
 * k = 2 (40, 30 | 30)
 * 70 + 0 + S(1,3) = 170
 * Min(160, 170) = 160
 *
 *
 * [2~4] => (30, 30, 50)
 * - 분할구간
 * k = 2.5 (30 | 30, 50)
 * 0 + 80 + S(2,4) =  190
 * k = 3.5 (30, 30 | 50)
 * 60 + 0 + S(2,4) = 170
 * Min(190, 170) = 170
 *
 * [3~5] => (30, 50, 20)
 * - 분할구간
 * k = 3.5 (30 | 50, 20)
 * 0 + 70 + S(3,5) =  170
 * k = 4.5 (30, 50 | 20)
 * 80 + 0 + S(3,5) = 180
 * Min(170, 180) = 170
 *
 * 3) 4개짜리 구간
 *
 * [1~4] => (40, 30, 30, 50)
 * - 분할구간
 * k = 1.5 (40 | 30, 30, 50)
 * 0 + DP(2,4) + S(1,4) = 320
 * k = 2.5 (40 , 30 | 30, 50)
 * DP(1,2) + DP(3,4) + S(1,4) = 300
 * k = 3.5 (40 , 30, 30 | 50)
 * DP(1,3) + 0 + S(1,4) = 310
 * Min(320, 300, 310) = 300
 *
 * [2~5] => (30, 30, 50, 20)
 * - 분할구간
 * k = 2.5 (30 | 30, 50, 20)
 * 0 + DP(3,5) + S(2,5) = 300
 * k = 3.5 (30, 30 | 50, 20)
 * DP(2,3) + DP(4,5) + S(2,5) = 260
 * k = 4.5 (30, 30, 50 | 20)
 * DP(2,4) + 0 + S(2,5) = 300
 * Min(300, 260, 300) = 260
 *
 */
