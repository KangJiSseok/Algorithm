import java.io.*;
import java.util.*;

public class 주사위굴리기2 {
    static int[] dice = {1, 5, 6, 2, 3, 4};
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] board;
    static int N, M, K, result =0;
    static int cy =0, cx = 0;

    // 0:동, 1:남, 2:서, 3:북
    static int direct = 0;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= K; i++) {
            one(cy, cx);
            result += bfs(cy, cx);  //two
            three();
        }

        System.out.println(result);
    }

    private static void three() {
        int A = dice[2];
        int B = board[cy][cx];
        if(A > B){  //시계
            direct = (direct + 1) > 3 ? 0 : (direct + 1);
        }else if(A <B){ //반시계
            direct = (direct - 1) <  0 ? 3 : (direct - 1);
        }else{
            return;
        }
    }

    private static void one(int y, int x) {
        //방향조절
        switch (direct) {
            case 0 :
                if (x + 1 >= M) direct = 2;
                break;
            case 1:
                if (y + 1 >= N) direct = 3;
                break;
            case 2:
                if (x - 1 < 0) direct = 0;
                break;
            case 3:
                if (y - 1 < 0) direct = 1;
                break;
        }
        //주사위이동
        if (direct == 0) east();
        else if (direct == 1) south();
        else if (direct == 2) west();
        else if (direct == 3) north();
    }

    static void east() {
        cx++;
        int tmp = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[4];
        dice[4] = tmp;
    }

    static void west() {
        cx--;
        int tmp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[5];
        dice[5] = tmp;
    }

    static void south() {
        cy++;
        int tmp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tmp;
    }

    static void north() {
        cy--;
        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = tmp;
    }

    static int bfs(int a, int b) {
//        System.out.println("a = " + (a + 1) + " b = " + (b + 1));
        visited = new boolean[N][M];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
                    if (board[a][b] == board[ny][nx]) {
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
//        System.out.println("count = " + count);
//        System.out.println("board = " + board[a][b]);
        return board[a][b] * count;
    }
}

