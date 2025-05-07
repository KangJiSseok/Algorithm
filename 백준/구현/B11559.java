import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B11559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dy = {0, -1, 1, 0};
	static int[] dx = {-1, 0, 0, 1};
	static int result = 0;

	public static void main(String[] args) throws IOException {

		init();

		while(true){
			boolean search = search();
			if(search) {
				result++;
				moveBottom();
			}
			else break;
		}

		System.out.println(result);
	}

	private static void moveBottom() {

		for (int i = 0; i < 6; i++) {
			for (int j = 10; j >= 0; j--) {
				int a = j;
				if (map[j][i] != '.') {
					while(a < 11){
						if(map[a + 1][i] == '.' && map[a][i] != '.'){
							map[a + 1][i] = map[a][i];
							map[a][i] = '.';
							a++;
						}else{
							break;
						}
					}
				}
			}
		}
	}

	private static boolean search() {
		visited = new boolean[12][6];
		boolean finded = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] != '.' && !visited[i][j]){
					if(bfs(map[i][j], i, j)){
						finded = true;
					}
				}
			}
		}

		if(finded) return true;
		else return false;
	}

	private static boolean bfs(char c, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		Stack<int[]> s = new Stack<>();

		q.add(new int[] {i, j});
		visited[i][j] = true;
		s.add(new int[] {i, j});

		while (!q.isEmpty()) {
			int[] p = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = p[0] + dy[k];
				int nx = p[1] + dx[k];
				if(ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
				if(!visited[ny][nx] && map[ny][nx] == c){
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
					s.add(new int[] {ny, nx});
				}
			}
		}

		if (s.size() >= 4) {
			while (!s.isEmpty()) {
				int[] p = s.pop();
				map[p[0]][p[1]] = '.';
			}

			return true;
		}

		return false;
	}

	private static void init() throws IOException {
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
}