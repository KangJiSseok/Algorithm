import java.awt.*;
import java.util.*;
import java.io.*;

public class 인구이동 {

    static int[][] board;
    static int[][] visit;
    static boolean isMove;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int N, L, R;
    static ArrayList<Point> points;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) {
            isMove = false;
            visit = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0) {
                        sum = 0;
                        points = new ArrayList<>();
                        bfs(i, j);
                        if (points.size() >= 2) {
                            int size = points.size();
                            int div = sum / size;
                            for (Point point : points) {
                                board[point.y][point.x] = div;
                            }
                        }
                    }
                }
            }
            if (isMove) {count++;}
            else {break;}

        }

        System.out.println(count);

    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        sum += board[a][b];
        points.add(new Point(a, b));
        visit[a][b] = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if (0 <= nY && nY < N && 0 <= nX && nX < N && visit[nY][nX] == 0) {
                    if (L <= Math.abs(board[y][x] - board[nY][nX]) &&
                            Math.abs(board[y][x] - board[nY][nX]) <= R) {
                        isMove = true;
                        visit[nY][nX] = 1;
                        q.add(new int[]{nY, nX});
                        points.add(new Point(nY, nX));
                        sum += board[nY][nX];
                    }
                }
            }
        }
    }

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
