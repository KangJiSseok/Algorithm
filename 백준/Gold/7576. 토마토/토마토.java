import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int N;
    static int M;
    static Queue<int[]> queue = new LinkedList<>();

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    queue.add(new int[]{i, j});
                    visit[i][j] = 1;
                } else if (value == -1) {
                    visit[i][j] = -1;
                }
                board[i][j] = value;
            }
        }
        bfs();

        boolean aaa = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0) {
                    aaa = false;
                }
                max = Math.max(visit[i][j], max);
            }
        }

        if(!aaa){
            System.out.println(-1);
        }else{
            System.out.println(max - 1);
        }

    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                    if (board[nextY][nextX] == 0 && visit[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY, nextX});
                        visit[nextY][nextX] = visit[y][x] + 1;
                    }
                }
            }
        }
    }
}


/**
 *
 * queue -> {0,0} , {3,5}
 */