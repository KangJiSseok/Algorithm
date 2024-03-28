import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int M;
    static int N;
    static boolean[][] vegetableVisit;
    static int[][] vegetable;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int o = 0; o < T; o++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());   //가로 길이
            N = Integer.parseInt(st.nextToken());   //세로 길이

            int K = Integer.parseInt(st.nextToken()); //배추 개수

            vegetable = new int[M][N];
            vegetableVisit = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                Arrays.fill(vegetableVisit[i], false);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                vegetable[a][b] = 1;
            }
            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (vegetable[i][j] == 1 && !vegetableVisit[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        Queue<int []> queue = new LinkedList<>();
        vegetableVisit[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + currentIndex[0];
                int ny = dy[k] + currentIndex[1];

                if (0 <= nx && nx < M && 0 <= ny && ny < N ) {
                    if (!vegetableVisit[nx][ny] && vegetable[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        vegetableVisit[nx][ny] = true;
                    }
                }
            }
        }

    }
}
