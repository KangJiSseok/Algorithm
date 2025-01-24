import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1261 {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}

		Deque<Node> d = new ArrayDeque<>();
		d.addFirst(new Node(0, 0, 0));
		visited[0][0] = true;

		while (!d.isEmpty()) {
			Node poll = d.pollFirst();
			if (poll.x == M - 1 && poll.y == N - 1) {
				System.out.println(poll.k);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];
				if (0 <= nx && nx < M && 0 <= ny && ny < N && !visited[ny][nx]) {
					if (board[ny][nx] == 1) {
						d.addLast(new Node(nx, ny, poll.k + 1));
						visited[ny][nx] = true;
					}else{
						d.addFirst(new Node(nx, ny, poll.k));
						visited[ny][nx] = true;
					}
				}
			}
		}

	}

	static class Node{
		int x,y, k;

		public Node(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}
