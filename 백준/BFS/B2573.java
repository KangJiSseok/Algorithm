import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573 {
	static int N, M;
	static int[][] board;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			boolean bool = a();
			year++;
			int count = b();
			if (count >= 2) {
				System.out.println(year);
				break;
			}

			if (!bool) {
				System.out.println(0);
				break;
			}
		}
	}

	//빙하 녹이기
	static boolean a(){
		boolean bool = false;

		Queue<int[]> q = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(board[y][x] == 0 )
					continue;

				int count = 0;
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					if (0 <= ny && ny < N && 0 <= nx && nx < M && board[ny][nx] == 0) {
						count++;
					}
				}
				if (count > 0) {
					q.add(new int[] {y, x, count});
				}
			}
		}

		if (q.size() > 0) {
			bool = true;
		}

		for (int[] yxc : q) {
			int y = yxc[0];
			int x = yxc[1];
			int c = yxc[2];

			board[y][x] = (board[y][x] - c) <= 0 ? 0 : board[y][x] - c;
		}

		return bool;
	}

	//나눠진 빙하 개수
	static int b() {
		boolean visited[][] = new boolean[N][M];
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (board[y][x] > 0 && !visited[y][x]) {
					count++;
					dfs(y, x, visited);
				}
			}
		}
		return count;
	}

	static void dfs(int y, int x, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		visited[y][x] = true;
		q.add(new int[] {y, x});

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && board[ny][nx] > 0) {
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
				}
			}
		}
	}
}
