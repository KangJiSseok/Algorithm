import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int L;
    static int[][] board;
    static int time = 0;

    //동남서북
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static Queue<D> queue = new LinkedList<>();
    static Deque<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int column = Integer.parseInt(st.nextToken()) - 1;
            board[row][column] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            queue.add(new D(second, direction));
        }

        snake.addLast(new int[]{0,0});
        int direction = 0;
        while (true) {
            
            time ++;

            int[] head = snake.peekFirst();
            int nextX = head[1] + dx[direction];
            int nextY = head[0] + dy[direction];

            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                break;
            }

            if(isFinish(nextY, nextX)){
                break;
            }

            if (board[nextY][nextX] == 1) {
                snake.addFirst(new int[]{nextY, nextX});
                board[nextY][nextX] = 0;
            }else{
                snake.addFirst(new int[]{nextY, nextX});
                snake.pollLast();
            }

            if (!queue.isEmpty() && time == queue.peek().second) {
                D poll = queue.poll();
                if (poll.direction == 'D') {
                    direction = (direction + 1 > 3) ? 0 : (direction + 1);
                } else {
                    direction = (direction - 1 < 0) ? 3 : (direction - 1);
                }
            }
        }

        System.out.println(time);
    }

    private static boolean isFinish(int y, int x) {
        for (int[] current: snake) {
            if (current[0] == y && current[1] == x) {
                return true;
            }
        }
        return false;
    }


}

class D{
    int second;
    char direction;

    public D(int second, char direction) {
        this.second = second;
        this.direction = direction;
    }
}
