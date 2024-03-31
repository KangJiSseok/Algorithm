import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int max = 0;
    static int count = 0;

    static int[][] array;
    static Boolean[][] arrayVisit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        arrayVisit = new Boolean[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arrayVisit[i], false);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[x - 1][y - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arrayVisit[i][j] && array[i][j] == 1) {
                    count = 0;
                    dps(i, j);
                    if (max < count) {
                        max = count;
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println("\n");
//        }

        System.out.println(max);

    }

    static void dps(int x, int y) {
        count++;
        // 방문 시작
        arrayVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (0 <= nx && nx < N && 0 <= ny && ny < M && !arrayVisit[nx][ny] && array[nx][ny] == 1) {
                arrayVisit[nx][ny] = true;
                array[nx][ny] = 1;
                dps(nx, ny);
            }
        }
    }
}
