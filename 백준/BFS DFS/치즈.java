import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈 {
    static int[][] board;
    static int[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int cheese = 0;
    static int day = 0;
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                board[i][j] = value;
                if (value == 1) {
                    cheese++;
                }
            }
        }

        while (cheese > 0) {
            day++;

            for (int i = 0; i < N; i++) {
                Arrays.fill(visit[i], 0);
            }

            dfs(0, 0);

            Stack<int[]> stack1 = new Stack<>();
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            //뺼꺼 뺴고 나중에 한번에 넣어야함
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                int notCheese = 0;
                for (int j = 0; j < 4; j++) {
                    int nextY = y + dy[j];
                    int nextX = x + dx[j];
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        if(board[nextY][nextX] == 0 && visit[nextY][nextX] == 1) notCheese++;
                    }
                }
                if (notCheese >= 2) {
                    stack1.add(new int[]{y, x});
                }
            }

            cheese -= stack1.size();
            int stack1Size = stack1.size();
            //한번에 넣기
            for (int i = 0; i < stack1Size; i++) {
                int[] pop = stack1.pop();
                board[pop[0]][pop[1]] = 0;
            }

        }

        System.out.println(day);
    }

    static void dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                if (visit[nextY][nextX] == 0 && board[nextY][nextX] == 0) {
                    visit[nextY][nextX] = 1;
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
