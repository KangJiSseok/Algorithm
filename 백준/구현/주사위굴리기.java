import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 주사위굴리기 {

    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int[][] board;
    static int N, M, x, y, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int direction = Integer.parseInt(st.nextToken());
            int nextY;
            int nextX;
            switch (direction) {
                case 1 :
                    nextY = y;
                    nextX = x + 1;
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        y = nextY;
                        x = nextX;
                        eastRotate();
                        if (board[y][x] != 0){
                            dice[6] = board[y][x];
                            board[y][x] = 0;
                        }
                        else board[y][x] = dice[6];
                        sb.append(dice[1] + "\n");
                    }
                    break;
                case 2:
                    nextY = y;
                    nextX = x - 1;
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        y = nextY;
                        x = nextX;
                        westRotate();
                        if (board[y][x] != 0){
                            dice[6] = board[y][x];
                            board[y][x] = 0;
                        }
                        else board[y][x] = dice[6];
                        sb.append(dice[1] + "\n");
                    }
                    break;
                case 3:
                    nextY = y - 1;
                    nextX = x;
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        y = nextY;
                        x = nextX;
                        northRotate();
                        if (board[y][x] != 0){
                            dice[6] = board[y][x];
                            board[y][x] = 0;
                        }
                        else board[y][x] = dice[6];
                        sb.append(dice[1] + "\n");
                    }
                    break;
                case 4:
                    nextY = y + 1;
                    nextX = x;
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        y = nextY;
                        x = nextX;
                        southRotate();
                        if (board[y][x] != 0){
                            dice[6] = board[y][x];
                            board[y][x] = 0;
                        }
                        else board[y][x] = dice[6];
                        sb.append(dice[1] + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    static void northRotate() {
        int two = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = two;
    }

    static void southRotate() {
        int six = dice[6];
        dice[6] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[2];
        dice[2] = six;
    }

    static void eastRotate() {
        int three = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = three;
    }

    static void westRotate() {
        int four = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = four;
    }
}


/**
 *   2
 * 4 1 3
 *   5
 *   6
 *
 * -----0번째------
 *   0
 * 0 0 0
 *   0
 *   0
 * 0 2
 * 3 4
 * 5 6
 * 7 8
 * -----1번째------
 *   0
 * 0 0 0
 *   0
 *   3
 * 0 2
 * 0 4
 * 5 6
 * 7 8
 * 출력값 : 0
 * -----2번째------
 *   3
 * 0 0 0
 *   0
 *   5
 * 0 2
 * 0 4
 * 0 6
 * 7 8
 * 출력값 : 0
 * -----3번째------
 *   5
 * 0 3 0
 *   0
 *   7
 * 0 2
 * 0 4
 * 0 6
 * 0 8
 * 출력값 : 3
 * -----4번째------
 *   5
 * 7 0 3
 *   0
 *   8
 * 0 2
 * 0 4
 * 0 6
 * 0 0
 * 출력값 : 0
 * -----5번째------
 *   0
 * 7 0 3
 *   8
 *   6
 * 0 2
 * 0 4
 * 0 0
 * 0 0
 * 출력값 : 0
 * -----6번째------
 *   0
 * 7 8 3
 *   6
 *   4
 * 0 2
 * 0 0
 * 0 0
 * 0 0
 * 출력값 : 8
 * -----7번째------
 *   8
 * 7 6 3
 *   4
 *   2
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 출력값 : 6
 * -----8번째------
 *   8
 * 6 3 2
 *   4
 *   7
 * 7 0
 * 0 0
 * 0 0
 * 0 0
 * 출력값 : 3
 */