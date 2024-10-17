import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사상어비바라기 {
    /**
     *  di : ←, ↖, ↑, ↗, →, ↘, ↓, ↙
     *  si : 이동 할 거리
     */

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][] board;
    static ArrayList<Main.Cloud> clouds = new ArrayList<>();

    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new Main.Cloud(N - 2, 0));
        clouds.add(new Main.Cloud(N - 2, 1));
        clouds.add(new Main.Cloud(N - 1, 0));
        clouds.add(new Main.Cloud(N - 1, 1));


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            //step 1. 구름 이동
            moveCloud(d, s);
            //step 2. 바구니에 물 넣기
            waterPut();
            //step 3. 대각선 찾고 물 넣기
            waterLinePut();
            //step 4. 구름 제거 후 생성
            cloudRemoveAndCreate();

//            System.out.println();
//            for (int j = 0; j < N; j++) {
//                System.out.println();
//                for (int k = 0; k < N; k++) {
//                    System.out.print(board[j][k] + "  ");
//                }
//            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += board[i][j];
            }
        }
        System.out.println(result);

    }

    private static void cloudRemoveAndCreate() {

        boolean[][] visit = new boolean[N][N];
        for (Main.Cloud cloud : clouds) {
            visit[cloud.y][cloud.x] = true;
        }

        clouds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] >= 2 && !visit[i][j]) {
                    clouds.add(new Main.Cloud(i, j));
                    board[i][j] -= 2;
                }
            }
        }

    }

    private static void waterLinePut() {
        HashMap<List<Integer>, Integer> map =new HashMap<>();

        for (Main.Cloud cloud : clouds) {
            for (int i = 1; i < 8; i = i + 2) {
                int nextY = cloud.y + dy[i];
                int nextX = cloud.x + dx[i];
                if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N && board[nextY][nextX] > 0) {
                    map.put(new ArrayList<>(Arrays.asList(cloud.y, cloud.x)),
                            map.getOrDefault(new ArrayList<>(Arrays.asList(cloud.y, cloud.x)), 0) + 1);
                }
            }
        }

        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            List<Integer> pos = entry.getKey();
            int y = pos.get(0);
            int x = pos.get(1);
            int sum = entry.getValue();
            board[y][x] += sum;
        }
    }

    private static void waterPut() {
        for (Main.Cloud cloud : clouds) {
            board[cloud.y][cloud.x]++;
        }
    }

    private static void moveCloud(int d, int s) {
        for (Main.Cloud cloud : clouds) {
            cloud.y = (N + cloud.y + dy[d] * (s % N)) % N;
            cloud.x = (N + cloud.x + dx[d] * (s % N)) % N;
        }
    }

    static class Cloud{
        int y;
        int x;

        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

/**
 * 0    0   0   0   1
 * 1    1   1   0   0
 * 1    1   1   1   0
 * 0    0   0   0   0
 * 1    1   0   0   0
 *
 * 구름 ↑ 3번 이동
 * 1    1   0   0   0
 * 0    0   0   0   1
 * 1    1   1   0   0
 * 1    1   1   1   0
 * 0    0   0   0   0
 *
 * 구름 자리에 비 내림
 * 1	1	1	0	0
 * 0	1	0	1	1
 * 3	2	1	7	0
 * 2	1	8	13	0
 * 6	6	4	3	0
 *
 * 물 복사 버그
 * 2	1	1	0	0
 * 0	1	0	1	2
 * 5	4	5	7	0
 * 4	5	12	15	0
 * 6	6	4	3	0
 *
 * //새로운 구름 생성
 * 2	1	1	0	0
 * 0	1	0	1	2
 * 5	4	5	51	0
 * 4	5	12	15	0
 * 41	41	21	11	0
 */