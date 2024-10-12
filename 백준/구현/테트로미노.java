import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {

    static int[][] board;
    static int[][] visit;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int N;
    static int M;

    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = 1;
                dfs(0, i, j);
                visit[i][j] = 0;
            }
        }
        //도형 4개 max값
//        System.out.println(max);

        //마지막 도형 최대값포함
        finalFuntion();
        System.out.println(max);

    }

    static void finalFuntion(){
        //ㅜ
        for (int i = 0; i < M - 2; i++) {
            for (int j = 0; j < N - 1; j++) {
                int finalSum = 0;
                finalSum += board[j][i] + board[j][i + 1] + board[j][i + 2] + board[j + 1][i + 1];
                max = Math.max(max, finalSum);
            }
        }

        //ㅗ
        for (int i = 0; i < M - 2; i++) {
            for (int j = 1; j < N; j++) {
                int finalSum = 0;
                finalSum += board[j][i] + board[j][i + 1] + board[j][i + 2] + board[j - 1][i + 1];
                max = Math.max(max, finalSum);
            }
        }

        //ㅏ
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 2; j++) {
                int finalSum = 0;
                finalSum += board[j][i] + board[j + 1][i] + board[j + 2][i] + board[j + 1][i + 1];
                max = Math.max(max, finalSum);
            }
        }

        //ㅓ
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N - 2; j++) {
                int finalSum = 0;
                finalSum += board[j][i] + board[j + 1][i] + board[j + 2][i] + board[j + 1][i - 1];
                max = Math.max(max, finalSum);
            }
        }
    }

    static void dfs(int depth, int y, int x) {
        max = Math.max(sum, max);
        if (depth == 4) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M && visit[nextY][nextX] == 0) {
                visit[nextY][nextX] = 1;
                sum += board[y][x];
                dfs(depth + 1, nextY, nextX);
                visit[nextY][nextX] = 0;
                sum -= board[y][x];
            }
        }
    }
}