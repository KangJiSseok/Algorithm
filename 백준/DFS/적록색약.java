import java.io.*;
import java.util.*;

public class 적록색약 {

    static int[][] visit;
    static int[][] board;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visit = new int[N][N];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String text = br.readLine();
            for (int j = 0; j < N; j++) {
                if (text.charAt(j) == 'R') {
                    board[i][j] = 1;
                } else if (text.charAt(j) == 'G') {
                    board[i][j] = 2;
                }else{
                    board[i][j] = 3;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    count++;
                    dfs(i, j, board[i][j]);
                }
            }
        }

        sb.append(count+" ");

        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], 0);
        }

        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j] == 0){
                    count++;
                    if (board[i][j] == 1 || board[i][j] == 2) {
                        RGDfs(i, j);
                    }else{
                        dfs(i, j, board[i][j]);
                    }
                }
            }
        }
        sb.append(count);

        System.out.println(sb.toString());


    }

    private static void RGDfs(int y, int x) {
        visit[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N && visit[nextY][nextX] == 0) {
                if (board[nextY][nextX] == 1 || board[nextY][nextX] == 2) {
                    RGDfs(nextY,nextX);
                }
            }
        }
    }

    private static void dfs(int y, int x, int color) {
        visit[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N && visit[nextY][nextX] == 0) {
                if (board[nextY][nextX] == color) {
                    dfs(nextY, nextX, color);
                }
            }
        }

    }
}


