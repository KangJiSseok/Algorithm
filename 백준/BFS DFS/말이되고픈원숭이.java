import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 말이되고픈원숭이 {

    static int[] nightDX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] nightDY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int K, W, H;
    static Queue<Node> q = new LinkedList<>();

    static int[][] board = new int[200][200];
    static int[][][] visit = new int[31][200][200];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 200; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        q.add(new Node(0, 0, 0));
        visit[0][0][0] = 0;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            int y = poll.y;
            int x = poll.x;
            int k = poll.k;

            //도착지점에 도달했을때
            if (y == H - 1 && x == W - 1) return visit[k][y][x];

            // K에 도달하면 방향은 상하좌우밖에 안됨.
            if(k == K){
                fourWay(poll, y, x, k);
            }
            if (k < K) {
                eightWay(y, x, k);
                fourWay(poll, y, x, k);
            }
        }
        return -1;
    }

    private static void eightWay(int y, int x, int k) {
        for (int i = 0; i < 8; i++) {
            int nY = y + nightDY[i];
            int nX = x + nightDX[i];
            if (isLimit(nY, nX)) {
                if (visit[k + 1][nY][nX] > visit[k][y][x] + 1) {
                    visit[k + 1][nY][nX] = visit[k][y][x] + 1;
                    q.add(new Node(nY, nX, k + 1));
                }
            }
        }
    }

    private static void fourWay(Node poll, int y, int x, int k) {
        for (int i = 0; i < 4; i++) {
            int nY = poll.y + dy[i];
            int nX = poll.x + dx[i];
            if (isLimit(nY, nX)) {
                if (visit[k][nY][nX] > visit[k][y][x] + 1) {
                    visit[k][nY][nX] = visit[k][y][x] + 1;
                    q.add(new Node(nY, nX, k));
                }
            }
        }
    }

    private static boolean isLimit(int nY, int nX) {
        return 0 <= nY && nY < H && 0 <= nX && nX < W && board[nY][nX] == 0;
    }


    static class Node {
        int y, x, k;

        public Node(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
}
