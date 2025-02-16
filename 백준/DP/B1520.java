import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1520 {
	static int N, M;
	static int[][] board;
	static int[][] dp;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));

	}

	static int dfs(int y, int x) {

		if (y == N - 1 && x == M - 1) {
			return 1;
		}

		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < N && 0 <= nx && nx < M && board[ny][nx] < board[y][x] ) {
				dp[y][x] += dfs(ny, nx);
			}

		}

		return dp[y][x];
	}
}

/**
 * 4 5
 * 50 45 37 32 30
 * 35 50 40 20 25
 * 30 30 25 17 28
 * 27 24 22 15 10
 *
 * dp[4][5]
 * -1	-1	-1	-1	-1
 * -1	-1	-1	-1	-1
 * -1	-1	-1	-1	-1
 * -1	-1	-1	-1	-1
 * -------step1--------
 * 1	-1	-1	-1	-1
 * 1	-1	-1	-1	-1
 * 1	-1	-1	-1	-1
 * 1	1	1	1	1
 * -------step2--------
 * 2	1	1	1	-1
 * 1	-1	-1	1	-1
 * 1	-1	-1	1	-1
 * 1	1	1	1	1
 * -------step3--------
 * 3	2	2	2	1
 * 1	-1	-1	1	1
 * 1	-1	-1	1	-1
 * 1	1	1	1	1
 */
