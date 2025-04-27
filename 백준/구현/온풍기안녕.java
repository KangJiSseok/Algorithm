import java.io.*;
import java.util.*;

public class 온풍기안녕 {

	static int[][] map;
	static int R, C, K, result = 0;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Heater> heaterList = new ArrayList<>();
	static ArrayList<SearchPlace> searchList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		init();

		while (true) {
			stepOne();
			stepTwo();
			stepThree();
			stepFour();
			if (stepFive()) {
				System.out.println(result);
				break;
			} else if (result >= 100) {
				System.out.println(101);
				break;
			}
		}
	}

	private static void stepFour() {
		result++;
	}

	private static boolean stepFive() {
		for (SearchPlace searchPlace : searchList) {
			if (map[searchPlace.x][searchPlace.y] < K)
				return false;
		}
		return true;
	}

	private static void stepThree() {
		for (int i = 2; i <= R * 2; i += 2) {
			if (map[i][2] > 0)
				map[i][2]--;
			if (map[i][C * 2] > 0)
				map[i][C * 2]--;
		}

		for (int i = 4; i <= C * 2 - 2; i += 2) {
			if (map[2][i] > 0)
				map[2][i]--;
			if (map[R * 2][i] > 0)
				map[R * 2][i]--;
		}
	}

	private static void stepTwo() {
		int[][] sumMap = new int[R * 2 + 4][C * 2 + 4];
		for (int i = 2; i < R * 2 + 2; i += 2) {
			for (int j = 2; j < C * 2 + 2; j += 2) {
				if (map[i][j] != 0) {
					//top
					if (map[i][j] > map[i - 2][j] && map[i - 1][j] != -1 && map[i - 2][j] != -1) {
						int sub = map[i][j] - map[i - 2][j];
						int div = sub / 4;
						sumMap[i - 2][j] += div;
						sumMap[i][j] -= div;
					}
					//bottom
					if (map[i][j] > map[i + 2][j] && map[i + 1][j] != -1 && map[i + 2][j] != -1) {
						int sub = map[i][j] - map[i + 2][j];
						int div = sub / 4;
						sumMap[i + 2][j] += div;
						sumMap[i][j] -= div;
					}
					//left
					if (map[i][j] > map[i][j - 2] && map[i][j - 1] != -1 && map[i][j - 2] != -1) {
						int sub = map[i][j] - map[i][j - 2];
						int div = sub / 4;
						sumMap[i][j - 2] += div;
						sumMap[i][j] -= div;
					}
					//right
					if (map[i][j] > map[i][j + 2] && map[i][j + 1] != -1 && map[i][j + 2] != -1) {
						int sub = map[i][j] - map[i][j + 2];
						int div = sub / 4;
						sumMap[i][j + 2] += div;
						sumMap[i][j] -= div;
					}
				}
			}
		}

		for (int i = 2; i < R * 2 + 2; i += 2) {
			for (int j = 2; j < C * 2 + 2; j += 2) {
				map[i][j] += sumMap[i][j];
			}
		}
	}

	private static void stepOne() {
		for (Heater heater : heaterList) {
			if (heater.dir == 1)
				dirRight(heater.x, heater.y);
			else if (heater.dir == 2)
				dirLeft(heater.x, heater.y);
			else if (heater.dir == 3)
				dirTop(heater.x, heater.y);
			else if (heater.dir == 4)
				dirBottom(heater.x, heater.y);
		}
	}

	private static void dirTop(int x, int y) {
		boolean[][] visited = new boolean[R * 2 + 4][C * 2 + 4];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x - 2, y, 4});
		visited[x - 2][y] = true;
		map[x - 2][y] += 5;
		while (!q.isEmpty()) {

			int[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			int ps = poll[2];
			if (ps == 0)
				continue;
			if (px - 2 < 0 || px + 2 >= map.length || py - 2 < 0 || py + 2 >= map[0].length) continue;
			if (map[px][py - 1] != -1 && map[px - 1][py - 2] != -1 && map[px - 2][py - 2] != -1 && !visited[px - 2][py
				- 2]) {
				visited[px - 2][py - 2] = true;
				q.add(new int[] {px - 2, py - 2, ps - 1});
				map[px - 2][py - 2] += ps;
			}

			if (map[px - 1][py] != -1 && map[px - 2][py] != -1 && !visited[px - 2][py]) {
				visited[px - 2][py] = true;
				q.add(new int[] {px - 2, py, ps - 1});
				map[px - 2][py] += ps;
			}

			if (map[px][py + 1] != -1 && map[px - 1][py + 2] != -1 && map[px - 2][py + 2] != -1 && !visited[px - 2][py
				+ 2]) {
				visited[px - 2][py + 2] = true;
				q.add(new int[] {px - 2, py + 2, ps - 1});
				map[px - 2][py + 2] += ps;
			}

		}
	}

	private static void dirBottom(int x, int y) {
		boolean[][] visited = new boolean[R * 2 + 4][C * 2 + 4];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x + 2, y, 4});
		visited[x + 2][y] = true;
		map[x + 2][y] += 5;
		while (!q.isEmpty()) {

			int[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			int ps = poll[2];
			if (ps == 0)
				continue;
			if (px - 2 < 0 || px + 2 >= map.length || py - 2 < 0 || py + 2 >= map[0].length) continue;
			if (map[px][py + 1] != -1 && map[px + 1][py + 2] != -1 && map[px + 2][py + 2] != -1 && !visited[px + 2][py
				+ 2]) {
				visited[px + 2][py + 2] = true;
				q.add(new int[] {px + 2, py + 2, ps - 1});
				map[px + 2][py + 2] += ps;
			}

			if (map[px + 1][py] != -1 && map[px + 2][py] != -1 && !visited[px + 2][py]) {
				visited[px + 2][py] = true;
				q.add(new int[] {px + 2, py, ps - 1});
				map[px + 2][py] += ps;
			}

			if (map[px][py - 1] != -1 && map[px + 1][py - 2] != -1 && map[px + 2][py - 2] != -1 && !visited[px + 2][py
				- 2]) {
				visited[px + 2][py - 2] = true;
				q.add(new int[] {px + 2, py - 2, ps - 1});
				map[px + 2][py - 2] += ps;
			}

		}
	}

	private static void dirRight(int x, int y) {
		boolean[][] visited = new boolean[R * 2 + 4][C * 2 + 4];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y + 2, 4});
		visited[x][y + 2] = true;
		map[x][y + 2] += 5;
		while (!q.isEmpty()) {

			int[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			int ps = poll[2];
			if (ps == 0)
				continue;
			if (px - 2 < 0 || px + 2 >= map.length || py - 2 < 0 || py + 2 >= map[0].length) continue;
			if (map[px - 1][py] != -1 && map[px - 2][py + 1] != -1 && map[px - 2][py + 2] != -1 && !visited[px - 2][py
				+ 2]) {
				visited[px - 2][py + 2] = true;
				q.add(new int[] {px - 2, py + 2, ps - 1});
				map[px - 2][py + 2] += ps;
			}

			if (map[px][py + 1] != -1 && map[px][py + 2] != -1 && !visited[px][py + 2]) {
				visited[px][py + 2] = true;
				q.add(new int[] {px, py + 2, ps - 1});
				map[px][py + 2] += ps;
			}

			if (map[px + 1][py] != -1 && map[px + 2][py + 1] != -1 && map[px + 2][py + 2] != -1 && !visited[px + 2][py
				+ 2]) {
				visited[px + 2][py + 2] = true;
				q.add(new int[] {px + 2, py + 2, ps - 1});
				map[px + 2][py + 2] += ps;
			}

		}
	}

	private static void dirLeft(int x, int y) {
		boolean[][] visited = new boolean[R * 2 + 4][C * 2 + 4];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y - 2, 4});
		visited[x][y - 2] = true;
		map[x][y - 2] += 5;
		while (!q.isEmpty()) {

			int[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			int ps = poll[2];
			if (ps == 0)
				continue;
			if (px - 2 < 0 || px + 2 >= map.length || py - 2 < 0 || py + 2 >= map[0].length) continue;
			if (map[px + 1][py] != -1 && map[px + 2][py - 1] != -1 && map[px + 2][py - 2] != -1 && !visited[px + 2][py
				- 2]) {
				visited[px + 2][py - 2] = true;
				q.add(new int[] {px + 2, py - 2, ps - 1});
				map[px + 2][py - 2] += ps;
			}

			if (map[px][py - 1] != -1 && map[px][py - 2] != -1 && !visited[px][py - 2]) {
				visited[px][py - 2] = true;
				q.add(new int[] {px, py - 2, ps - 1});
				map[px][py - 2] += ps;
			}

			if (map[px - 1][py] != -1 && map[px - 2][py - 1] != -1 && map[px - 2][py - 2] != -1 && !visited[px - 2][py
				- 2]) {
				visited[px - 2][py - 2] = true;
				q.add(new int[] {px - 2, py - 2, ps - 1});
				map[px - 2][py - 2] += ps;
			}

		}
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R * 2 + 4][C * 2 + 4];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1 || value == 2 || value == 3 || value == 4) {
					heaterList.add(new Heater(i * 2, j * 2, value));
				} else if (value == 5) {
					searchList.add(new SearchPlace(i * 2, j * 2));
				}
			}
		}

		for (int i = 0; i < R * 2 + 4; i++) {
			map[i][0] = -1;
			map[i][1] = -1;
		}

		for (int i = 0; i < C * 2 + 4; i++) {
			map[0][i] = -1;
			map[1][i] = -1;
		}

		for (int i = 0; i < R * 2 + 4; i++) {
			map[i][C * 2 + 3] = -1;
			map[i][C * 2 + 2] = -1;
		}

		for (int i = 0; i < C * 2 + 4; i++) {
			map[R * 2 + 3][i] = -1;
			map[R * 2 + 2][i] = -1;
		}

		int W = Integer.parseInt(br.readLine());
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			if (t == 0) {
				map[2 * x - 1][y * 2] = -1;
			} else {
				map[2 * x][2 * y + 1] = -1;
			}
		}

	}

	static class Heater {
		int x, y, dir;

		public Heater(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	static class SearchPlace {
		int x, y;

		public SearchPlace(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
