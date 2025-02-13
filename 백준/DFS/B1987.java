import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {
	static char[][] board;
	static boolean[][] visited;
	static boolean[] alpha = new boolean[26];

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M, max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		visited[0][0] = true;
		alpha[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(max);
	}

	static void dfs(int y, int x, int count) {

		max = Math.max(max, count);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && !alpha[board[ny][nx] - 'A']) {
				alpha[board[ny][nx] - 'A'] = true;
				visited[ny][nx] = true;

				dfs(ny, nx, count + 1);

				alpha[board[ny][nx] - 'A'] = false;
				visited[ny][nx] = false;
			}
		}
	}
}
