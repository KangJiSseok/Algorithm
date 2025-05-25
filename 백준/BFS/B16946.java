import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16946 {
	static int N,M;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] map;
	static int[][] map2;
	static boolean[][] visited;

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		map2 = new int[N][M];
		parent = new int[N * M];
		visited = new boolean[N][M];
		for (int i = 0; i < N * M; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 0) bfs(i, j);
			}
		}
		//
		// System.out.println();
		// System.out.println();
		// for (int i = 0; i < N; i++) {
		// 	System.out.println();
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(map2[i][j] + " ");
		// 	}
		// }
		// System.out.println();
		//
		// //유파
		// System.out.println();
		// for (int i = 0; i < N; i++) {
		// 	System.out.println();
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(parent[i * M + j] + " ");
		// 	}
		// }
		// System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) sb.append(0);
				else if(map[i][j] == 1){
					HashSet<Integer> set = new HashSet<>();
					int count = 1;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(!set.contains(parent[ny * M + nx])){
							set.add(parent[ny * M + nx]);
							count += map2[ny][nx];
						}
					}
					sb.append((count) % 10);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs(int y, int x) {
		int count = 1;
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		q1.add(new int[] {y, x});
		q2.add(new int[] {y, x});
		visited[y][x] = true;

		while (!q1.isEmpty()) {
			int[] p = q1.poll();
			for (int k = 0; k < 4; k++) {
				int ny = p[0] + dy[k];
				int nx = p[1] + dx[k];

				if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 1 || visited[ny][nx]) continue;
				union(p[0] * M + p[1], ny * M + nx);
				visited[ny][nx] = true;
				q1.add(new int[]{ny, nx});
				q2.add(new int[]{ny, nx});
				count++;
				count %= 10;
			}
		}

		for(int[] p : q2){
			map2[p[0]][p[1]] = count;
		}
	}

	static void union(int x, int nx) {
		int a = find(x);
		int b = find(nx);
		if (a != b) {
			parent[b] = a;
		}
	}
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
