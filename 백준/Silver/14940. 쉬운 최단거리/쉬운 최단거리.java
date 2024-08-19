import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] array;
    static int[][] visit;
    static int n;
    static int m;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    array[i][j] = value;
                    visit[i][j] = 0;
                    queue.add(new int[]{i, j});
                }else{
                    array[i][j] = value;
                    visit[i][j] = -1;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == -1 && array[i][j] == 1) {
                    sb.append(-1 + " ");
                } else if (array[i][j] == 0) {
                    sb.append(0 + " ");
                }else{
                    sb.append(visit[i][j] + " ");
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void bfs() {

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = poll[0] + dy[i];
                int nextX = poll[1] + dx[i];

                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && visit[nextY][nextX] == -1 && array[nextY][nextX] != 0) {
                    queue.add(new int[]{nextY, nextX});
                    visit[nextY][nextX] = visit[poll[0]][poll[1]] + 1;
                }
            }
        }
    }

}