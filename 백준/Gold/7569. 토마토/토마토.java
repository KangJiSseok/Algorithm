import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][][] tomato;

    //방문확인과 동시에 max값 비교하는 배열.
    static int[][][] visit;
    static int[][][] day;
    static int[] dx = {-1, 0, 0, 1, 0, 0};
    static int[] dy = {0, -1, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int M;
    static int N;
    static int H;
    static int max = 0;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //============초기화 ============//
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];
        visit = new int[H][N][M];
        day = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        //============초기화 ============//


        bfs();


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(tomato[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    max = Math.max(day[i][j][k], max);
                }
            }
        }

        System.out.println(max);

//        System.out.println("==============");
//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(day[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }

    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            visit[poll[0]][poll[1]][poll[2]] = 1;
            for (int i = 0; i < 6; i++) {
                int nextZ = poll[0] + dz[i];
                int nextY = poll[1] + dy[i];
                int nextX = poll[2] + dx[i];
                if (0 <= nextZ && nextZ < H && 0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                    if (visit[nextZ][nextY][nextX] == 0) {
                        //익은토마토일 경우 전파할때 day는 증가하지 않음.
                        //가장자리까지 일단 가야하기 때문.
                        //안익은 토마토일 경우 익은토마토로 바꾸고 그 자리는 day + 1
                        if (tomato[nextZ][nextY][nextX] == 0) {
                            visit[nextZ][nextY][nextX] = 1;
                            tomato[nextZ][nextY][nextX] = 1;
                            day[nextZ][nextY][nextX] = day[poll[0]][poll[1]][poll[2]] + 1;
                            queue.add(new int[]{nextZ, nextY, nextX});
                        } else if (tomato[nextZ][nextY][nextX] == -1) {
                            continue;
                        }
                    }
                }
            }
        }
    }


}

