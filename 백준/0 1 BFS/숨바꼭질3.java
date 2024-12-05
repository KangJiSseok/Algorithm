import java.util.*;
import java.io.*;

public class 숨바꼭질3 {
    static int[] visit = new int[100001];
    static Deque<Integer> d = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(visit, -1);

        bfs(N, K);
        System.out.println(visit[K]);
    }

    static void bfs(int n, int k) {
        visit[n] = 0;
        d.addFirst(n);

        while (!d.isEmpty()) {
            int pos = d.pollFirst();
            if(pos == k) return;

            if (pos * 2 <= 100000 && visit[pos * 2] == -1) {
                d.addFirst(pos * 2);
                visit[pos * 2] = visit[pos];
            }
            if (pos > 0 && visit[pos - 1] == -1) {
                d.addLast(pos - 1);
                visit[pos - 1] = visit[pos] + 1;
            }
            if (pos < 100000 && visit[pos + 1] == -1) {
                d.addLast(pos + 1);
                visit[pos + 1] = visit[pos] + 1;
            }
        }
    }
}

/**
 * X위치일때 할 수 있는 경우의수
 * X - 1 or X + 1로 이동
 * 2 * X 로 이동
 *
 * 0 1 bfs이다.
 *
 */
