import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {
    static int[][] board = new int[1001][1001];
    static int[][][] visit = new int[11][1001][1001];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N, M, K;
    static Queue<Pos> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String text = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = text.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        queue.add(new Pos(1, 1, 0, 1));
        visit[0][1][1] = 1;

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            int y = poll.y;
            int x = poll.x;
            int destroy = poll.destroy;
            int distance = poll.distance;

            if (y == N && x == M) return distance;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if (nY <= 0 || nY > N || nX <= 0 || nX > M) continue;

                if (board[nY][nX] == 0 && (visit[destroy][nY][nX] == 0 || visit[destroy][nY][nX] > distance + 1)) {
                    visit[destroy][nY][nX] = distance + 1;
                    queue.add(new Pos(nY, nX, destroy, distance + 1));
                }

                if (board[nY][nX] == 1 && destroy < K && (visit[destroy + 1][nY][nX] == 0 || visit[destroy + 1][nY][nX] > distance + 1)) {
                    visit[destroy + 1][nY][nX] = distance + 1;
                    queue.add(new Pos(nY, nX, destroy + 1, distance + 1));
                }
            }
        }

        return -1;
    }

    static class Pos {
        int y, x, destroy, distance;

        public Pos(int y, int x, int destroy, int distance) {
            this.y = y;
            this.x = x;
            this.destroy = destroy;
            this.distance = distance;
        }
    }
}
