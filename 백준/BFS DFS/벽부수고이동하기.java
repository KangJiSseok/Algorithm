import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    static int[][] board = new int[1001][1001];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][][] visit = new int[1001][1001][2];
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String text = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = text.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());


    }

    private static int bfs() {

        queue.add(new int[]{1, 1, 0});
        visit[1][1][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int destroy = poll[2];
            if(y == N && x == M) return visit[y][x][destroy];

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if (1 <= nY && nY <= N && 1 <= nX && nX <= M && visit[nY][nX][destroy] == 0) {
                    if (board[nY][nX] == 0) {
                        visit[nY][nX][destroy] = visit[y][x][destroy] + 1;
                        queue.add(new int[]{nY, nX, destroy});
                    }

                    if (board[nY][nX] == 1 && destroy < 1) {
                        visit[nY][nX][destroy + 1] = visit[y][x][destroy] + 1;
                        queue.add(new int[]{nY, nX, destroy + 1});
                    }
                }
            }
        }

        return -1;
    }

}