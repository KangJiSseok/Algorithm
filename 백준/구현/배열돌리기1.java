import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, min;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		min = Math.min(N, M);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * 1	2	3	4
	 * 1	2	3	4
	 * 1	2	3	4
	 * 1	2	3	4
	 */
	/**
	 * (2,1) (1,1)
	 *
	 */
	public static void dfs(int i) {
		if ((N - 1 - i) - (i) <= 0 || (M - 1 - i) - (i) <= 0) {
			return;
		}

		int row = (M - i) - (i);
		int col = (N - i) - (i);
		int r = R % (2 * (row + col) - 4);

		for (int j = 0; j < r; j++) {
			rotate(i, i);
		}
		dfs(i + 1);
	}

	public static void rotate(int y, int x) {

		int temp = map[y][x];

		//위
		// N = 4 , M = 6, y = 1 , x = 1
		// (1,1) (1,2) (1,3)
		for (int i = x; i < M - x - 1; i++) {
			map[y][i] = map[y][i + 1];
		}

		//우
		// N = 4 , M = 6, y = 1 , x = 1
		// (1,4)
		for (int i = y; i < N - y - 1; i++) {
			map[i][M - x - 1] = map[i + 1][M - x - 1];
		}

		//하
		// N = 4 , M = 6, y = 1 , x = 1
		// (2,4) (2,3) (2,2)
		for (int i = M - x - 1; i > x; i--) {
			map[N - y - 1][i] = map[N - y - 1][i - 1];
		}

		//좌
		// N = 4 , M = 6, y = 1 , x = 1
		// (2,1)
		for (int i = N - y - 1; i > y; i--) {
			map[i][x] = map[i - 1][x];
		}

		map[y + 1][x] = temp;

	}
}
