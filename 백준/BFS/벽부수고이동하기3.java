import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 벽부수고이동하기3 {
	static int[][] board;
	static int[][][][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int N, M, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visited = new int[K + 1][2][N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		int ans = bfs();
		if (ans == -1) {
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}

	}

	static int bfs() {
		Deque<int[]> d = new ArrayDeque<>();
		visited[0][1][0][0] = 1;
		// y x k am count
		d.addFirst(new int[] {0, 0, 0, 1, 0});
		while (!d.isEmpty()) {
			int[] poll = d.pollLast();
			if (poll[0] == N - 1 && poll[1] == M - 1) {
				return poll[4] + 1;
			}
			int k = poll[2];
			int curAM = poll[3];
			int xorCurAM =  curAM ^ 1;
			for (int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				if (0 <= ny && ny < N && 0 <= nx && nx < M) {
					if (board[ny][nx] == 0 && visited[k][xorCurAM][ny][nx] == 0) {
						d.addFirst(new int[] {ny, nx, k, xorCurAM, poll[4] + 1});
						visited[k][xorCurAM][ny][nx] = 1;
					} else if (board[ny][nx] == 1 && curAM == 1 && k < K && visited[k + 1][xorCurAM][ny][nx] == 0) {
						d.addFirst(new int[] {ny, nx, k + 1, xorCurAM, poll[4] + 1});
						visited[k + 1][xorCurAM][ny][nx] = 1;
					}
				}
			}

			if (visited[k][xorCurAM][poll[0]][poll[1]] == 0) {
				d.addFirst(new int[] {poll[0], poll[1], k, xorCurAM, poll[4] + 1});
				visited[k][xorCurAM][poll[0]][poll[1]] = 1;
			}
		}
		return -1;
	}
}
