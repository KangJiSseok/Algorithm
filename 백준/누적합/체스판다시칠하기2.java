import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기2 {
	static int[][] board1;
	static int[][] board2;
	static int[][] pSum1;
	static int[][] pSum2;
	static int N, M, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board1 = new int[N + 1][M + 1];
		board2 = new int[N + 1][M + 1];
		pSum1 = new int[N + 1][M + 1];
		pSum2 = new int[N + 1][M + 1];

		/**
		 * W B W B W B
		 * B W B W B W
		 * W B W B W B
		 */
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				if ((i - 1) % 2 == 0) {
					/**
					 * W B W B W B
					 */
					if ((j- 1) % 2 == 0) {
						if (s.charAt(j - 1) == 'W') {
							board1[i][j] = 0;
							board2[i][j] = 1;
						} else {
							board1[i][j] = 1;
							board2[i][j] = 0;
						}
					} else {
						if (s.charAt(j - 1) == 'W') {
							board1[i][j] = 1;
							board2[i][j] = 0;
						} else {
							board1[i][j] = 0;
							board2[i][j] = 1;
						}
					}
				}
				/**
				 * B W B W B W
				 */
				else {
					if ((j - 1) % 2 == 0) {
						if (s.charAt(j - 1) == 'B') {
							board1[i][j] = 0;
							board2[i][j] = 1;
						} else {
							board1[i][j] = 1;
							board2[i][j] = 0;
						}
					} else {
						if (s.charAt(j - 1) == 'B') {
							board1[i][j] = 1;
							board2[i][j] = 0;
						} else {
							board1[i][j] = 0;
							board2[i][j] = 1;
						}
					}
				}
			}
		}


		pSum1 = sumFuntion(board1);
		pSum2 = sumFuntion(board2);


		// System.out.println("board1");
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println();
		// 	for (int j = 1; j <= M; j++) {
		// 		System.out.print(board1[i][j] + "	");
		// 	}
		// }
		//
		// System.out.println();
		// System.out.println("pSum1");
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println();
		// 	for (int j = 1; j <= M; j++) {
		// 		System.out.print(pSum1[i][j]+ "	");
		// 	}
		// }
		//
		//
		// System.out.println();
		// System.out.println("board2");
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println();
		// 	for (int j = 1; j <= M; j++) {
		// 		System.out.print(board2[i][j]+ "	");
		// 	}
		// }
		//
		//
		// System.out.println();
		// System.out.println("pSum2");
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println();
		// 	for (int j = 1; j <= M; j++) {
		// 		System.out.print(pSum2[i][j]+ "	");
		// 	}
		// }

		int min = Integer.MAX_VALUE;
		/**
		 * 4 , 3
		 */
		for (int i = N; i >= K ; i--) {
			for (int j = M; j >= K; j--) {
				// System.out.println("N = " + i + " M = " + j);
				min = Math.min(min,count(pSum1, i, j));
				min = Math.min(min,count(pSum2, i, j));
			}
		}

		System.out.println(min);
	}

	private static int[][] sumFuntion(int arr[][]) {
		int[][] pSum = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				pSum[i][j] = arr[i][j] + pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1];
			}
		}
		return pSum;
	}

	private static int count(int pSum[][], int i, int j) {
		return pSum[i][j] - (pSum[i - K][j] + pSum[i][j - K]) + pSum[i - K][j - K];
	}
}
