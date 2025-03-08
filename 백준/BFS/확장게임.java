import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 확장게임 {
	static int N, M, P;
	static int[][] board;
	static int[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[] pArr;
	static Queue<int[]>[] q;

	public static void main(String[] args) throws IOException {
		input();
		game();
	}

	private static void game() {
		while (true) {
			boolean anyExpanded = false; // 이번 라운드에서 확장 발생 여부

			for (int i = 1; i <= P; i++) {
				boolean expanded = bfs(i, pArr[i]);
				if (expanded) {
					anyExpanded = true;
				}
			}

			// 만약 한 라운드에서 아무도 확장을 못했다면 => 종료
			if (!anyExpanded) {
				int[] players = arrSearch();
				printResult(players);
				return;
			}

			// printBoard();
		}
	}

	private static boolean bfs(int player, int p) {
		boolean expand = false;

		for (int depth = 0; depth < p; depth++) {
			int size = q[player].size();
			if (size == 0) break;

			for (int j = 0; j < size; j++) {
				int[] poll = q[player].poll();
				for (int k = 0; k < 4; k++) {
					int ny = poll[0] + dy[k];
					int nx = poll[1] + dx[k];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if (board[ny][nx] != 0 || visited[ny][nx] != 0) continue;
					board[ny][nx] = player;
					visited[ny][nx] = 1;
					q[player].add(new int[] {ny, nx});
					expand = true;
				}
			}
		}

		return expand;
	}

	private static int[] arrSearch() {
		int[] players = new int[P + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int value = board[i][j];
				if (value == -1) continue;
				players[value]++;
			}
		}
		return players;
	}

	private static void printResult(int[] players) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= P; i++) {
			sb.append(players[i] + " ");
		}
		System.out.println(sb.toString());
	}

	private static void printBoard() {
		System.out.println("-------- Board --------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		q = new LinkedList[P + 1];
		for (int i = 1; i <= P; i++) {
			q[i] = new LinkedList<>();
		}

		board = new int[N][M];
		visited = new int[N][M];
		pArr = new int[P + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= P; i++) {
			pArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = line.charAt(j);
				if (c == '.') {
					board[i][j] = 0;
				} else if (c == '#') {
					board[i][j] = -1;
				} else {
					int player = c - '0';
					board[i][j] = player;
					visited[i][j] = 1;
					q[player].add(new int[]{i, j});
				}
			}
		}
	}
}
