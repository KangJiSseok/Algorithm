import java.io.*;
import java.util.*;
public class B12100 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, max;
	static int[][] board;


	public static void main(String[] args) throws IOException {

		init();
		dfs(5, board);
		System.out.println(max);
	}

	private static void dfs(int count, int[][] map) {
		if (count == 0) {
			checkBoard(map);
			return;
		}
		dfs(count - 1, moveLeft(map));
		dfs(count - 1, moveRight(map));
		dfs(count - 1, moveTop(map));
		dfs(count - 1, moveBottom(map));
	}

	private static void checkBoard(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
	}

	private static int[][] moveLeft(int[][] nMap) {
		int[][] copy = new int[N][N];
		// 1) 깊은 복사
		for (int i = 0; i < N; i++) {
			copy[i] = nMap[i].clone();
		}

		// 2) 빈 칸 당기기 (left)
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int i = col;
				while (i > 0 && copy[row][i - 1] == 0) {
					copy[row][i - 1] = copy[row][i];
					copy[row][i]     = 0;
					i--;
				}
			}
		}

		// 3) 합치기 (0 제외 + 한 번만)
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N - 1; col++) {
				if (copy[row][col] != 0 && copy[row][col] == copy[row][col + 1]) {
					copy[row][col]     *= 2;
					copy[row][col + 1] = 0;
					col++;
				}
			}
		}

		// 4) 다시 빈 칸 당기기 (left)
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int i = col;
				while (i > 0 && copy[row][i - 1] == 0) {
					copy[row][i - 1] = copy[row][i];
					copy[row][i]     = 0;
					i--;
				}
			}
		}

		return copy;
	}


	// 오른쪽으로 밀기
	private static int[][] moveRight(int[][] nMap) {
		int[][] copy = new int[N][N];
		// 1) 깊은 복사
		for (int i = 0; i < N; i++) {
			copy[i] = nMap[i].clone();
		}

		// 2) 빈 칸 당기기 (right)
		for (int row = 0; row < N; row++) {
			for (int col = N - 1; col >= 0; col--) {
				int i = col;
				while (i < N - 1 && copy[row][i + 1] == 0) {
					copy[row][i + 1] = copy[row][i];
					copy[row][i]     = 0;
					i++;
				}
			}
		}

		// 3) 합치기 (0 제외 + 한 번만)
		for (int row = 0; row < N; row++) {
			for (int col = N - 1; col > 0; col--) {
				if (copy[row][col] != 0 && copy[row][col] == copy[row][col - 1]) {
					copy[row][col]     *= 2;
					copy[row][col - 1] = 0;
					col--;  // 합친 블록 건너뛰기
				}
			}
		}

		// 4) 다시 빈 칸 당기기 (right)
		for (int row = 0; row < N; row++) {
			for (int col = N - 1; col >= 0; col--) {
				int i = col;
				while (i < N - 1 && copy[row][i + 1] == 0) {
					copy[row][i + 1] = copy[row][i];
					copy[row][i]     = 0;
					i++;
				}
			}
		}

		return copy;
	}

	// 위쪽으로 밀기
	private static int[][] moveTop(int[][] nMap) {
		int[][] copy = new int[N][N];
		// 1) 깊은 복사
		for (int i = 0; i < N; i++) {
			copy[i] = nMap[i].clone();
		}

		// 2) 빈 칸 당기기 (up)
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row++) {
				int i = row;
				while (i > 0 && copy[i - 1][col] == 0) {
					copy[i - 1][col] = copy[i][col];
					copy[i][col]     = 0;
					i--;
				}
			}
		}

		// 3) 합치기 (0 제외 + 한 번만)
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N - 1; row++) {
				if (copy[row][col] != 0 && copy[row][col] == copy[row + 1][col]) {
					copy[row][col]     *= 2;
					copy[row + 1][col] = 0;
					row++;  // 합친 블록 건너뛰기
				}
			}
		}

		// 4) 다시 빈 칸 당기기 (up)
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row++) {
				int i = row;
				while (i > 0 && copy[i - 1][col] == 0) {
					copy[i - 1][col] = copy[i][col];
					copy[i][col]     = 0;
					i--;
				}
			}
		}

		return copy;
	}

	// 아래쪽으로 밀기
	private static int[][] moveBottom(int[][] nMap) {
		int[][] copy = new int[N][N];
		// 1) 깊은 복사
		for (int i = 0; i < N; i++) {
			copy[i] = nMap[i].clone();
		}

		// 2) 빈 칸 당기기 (down)
		for (int col = 0; col < N; col++) {
			for (int row = N - 1; row >= 0; row--) {
				int i = row;
				while (i < N - 1 && copy[i + 1][col] == 0) {
					copy[i + 1][col] = copy[i][col];
					copy[i][col]     = 0;
					i++;
				}
			}
		}

		// 3) 합치기 (0 제외 + 한 번만)
		for (int col = 0; col < N; col++) {
			for (int row = N - 1; row > 0; row--) {
				if (copy[row][col] != 0 && copy[row][col] == copy[row - 1][col]) {
					copy[row][col]     *= 2;
					copy[row - 1][col] = 0;
					row--;  // 합친 블록 건너뛰기
				}
			}
		}

		// 4) 다시 빈 칸 당기기 (down)
		for (int col = 0; col < N; col++) {
			for (int row = N - 1; row >= 0; row--) {
				int i = row;
				while (i < N - 1 && copy[i + 1][col] == 0) {
					copy[i + 1][col] = copy[i][col];
					copy[i][col]     = 0;
					i++;
				}
			}
		}

		return copy;
	}


	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
