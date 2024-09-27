import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {

    static int[] board = new int[101];
    static int[] visit = new int[101];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (true) {
            int pos = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int nextPos = pos + i;
                if (nextPos == 100) {
                    System.out.println(visit[pos] + 1);
                    return;
                }
                if (board[nextPos] < 100 && visit[board[nextPos]] == 0) {
                    queue.add(board[nextPos]);
                    visit[board[nextPos]] = visit[board[pos]] + 1;
                }
            }
        }

    }
}
