import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] miro;
    static boolean[][] miroVisit;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String maze = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = maze.charAt(j) - '0';
            }
        }

        miroVisit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(miroVisit[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (miro[i][j] == 1 && !miroVisit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(miro[N - 1][M - 1]);
    }

    private static void bfs(int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{i, j});
        miroVisit[i][j] = true;

        while (!deque.isEmpty()) {
            int[] currentIndex = deque.poll();
            int x = currentIndex[0];
            int y = currentIndex[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!miroVisit[nx][ny] && miro[nx][ny] == 1) {
                        deque.add(new int[]{nx, ny});
                        miroVisit[nx][ny] = true;
                        miro[nx][ny] = miro[x][y] + 1;
                    }
                }
            }
        }
    }
}