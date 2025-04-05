import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	static int[][] board;
	static boolean[][] visited;

	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int islandNumber = 1;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 0)
					board[i][j] = -1;
				else
					board[i][j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] == 0)
					putIslandNumber(i, j, islandNumber++);
			}
		}

		HashSet<Integer> set = new HashSet<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] != -1 && !set.contains(board[i][j])) {
					min = Math.min(min, searchIsland(i, j));
					set.add(board[i][j]);
				}
			}
		}


		System.out.println(min);
	}

	private static void putIslandNumber(int i, int j, int islandNumber) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		board[i][j] = islandNumber;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int k = 0; k < 4; k++) {
				int ny = p[0] + dy[k];
				int nx = p[1] + dx[k];
				if (0 <= ny && ny < N && 0 <= nx && nx < N && board[ny][nx] == 0 && !visited[ny][nx]) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;
					board[ny][nx] = islandNumber;
				}
			}
		}
	}

	private static int searchIsland(int y, int x) {
		int num = board[y][x];
		visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == num) {
					q.add(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] p = q.poll();

			if(board[p[0]][p[1]] != -1 && board[p[0]][p[1]] != num) return p[2] - 1;

			for (int k = 0; k < 4; k++) {
				int ny = p[0] + dy[k];
				int nx = p[1] + dx[k];

				if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
					q.add(new int[] {ny, nx, p[2] + 1});
					visited[ny][nx] = true;
				}
			}
		}

		return 0;
	}
}
