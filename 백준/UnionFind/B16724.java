import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16724 {
	static int N,M;

	//위 아래 왼쪽 오른쪽
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] map;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		parent = new int[N * M];

		for (int i = 0; i < N * M; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if(c == 'U')map[i][j] = 0;
				else if (c == 'D') map[i][j] = 1;
				else if(c == 'L') map[i][j] = 2;
				else map[i][j] = 3;
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				int ny = y + dy[map[y][x]];
				int nx = x + dx[map[y][x]];
				union(y * M + x, ny * M + nx);
			}
		}

		int result = 0;
		for (int i = 0; i < N * M; i++) {
			if(parent[i] == i) result++;
		}
		System.out.println(result);
	}


	static void union(int x, int nx) {
		int a = find(x);
		int b = find(nx);
		if (a != b) {
			parent[b] = a;
		}
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);	//경로 압축
	}
}
