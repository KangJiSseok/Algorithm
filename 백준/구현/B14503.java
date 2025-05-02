import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}; // 북 동 남 서
	static int[] dy = {-1, 0, 1, 0};
	static Main.Cleaning clean;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		clean = new Main.Cleaning(y, x, d);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		while (true) {
			// 1. 현재 위치가 청소되지 않았으면 청소
			if (map[clean.y][clean.x] == 0) {
				map[clean.y][clean.x] = 2;
				result++;
			}

			// 2. 주변 4칸 중 청소되지 않은 칸이 있는지 확인
			if (checkUncleanedAdjacent(clean.y, clean.x)) {
				stepThree(); // 왼쪽 방향부터 탐색
			} else {
				if (!stepTwo()) break; // 후진 불가면 종료
			}
		}

		System.out.println(result);
	}

	// 후진
	static boolean stepTwo() {
		int back = (clean.d + 2) % 4;
		int ny = clean.y + dy[back];
		int nx = clean.x + dx[back];

		if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 1) return false;

		clean.y = ny;
		clean.x = nx;
		return true;
	}

	// 왼쪽부터 4방향 탐색
	static void stepThree() {
		for (int i = 0; i < 4; i++) {
			clean.d = (clean.d + 3) % 4;
			int ny = clean.y + dy[clean.d];
			int nx = clean.x + dx[clean.d];

			if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
				clean.y = ny;
				clean.x = nx;
				return;
			}
		}
		// 모든 방향에 청소할 곳이 없다면 아무 일도 하지 않음 (다음 반복에서 후진 시도)
	}

	static boolean checkUncleanedAdjacent(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (map[ny][nx] == 0) return true;
		}
		return false;
	}

	static class Cleaning {
		int y, x, d;

		public Cleaning(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
