import java.util.*;
import java.io.*;

public class 숨바꼭질2 {
    static int[] visit = new int[100001];
    static int cases = 0;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(visit, -1);

        bfs(N, K);

        System.out.println(minTime);
        System.out.println(cases);
    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 0;

        while (!q.isEmpty()) {
            int pos = q.poll();

            if (pos == k) {
                if (minTime > visit[pos]) {
                    minTime = visit[pos];
                    cases = 1;
                } else if (minTime == visit[pos]) {
                    cases++;
                }
            }

            int[] nextPos = { pos * 2, pos - 1, pos + 1 };

            for (int next : nextPos) {
                if (next >= 0 && next <= 100000) {
                    if (visit[next] == -1 || visit[next] == visit[pos] + 1) {
                        visit[next] = visit[pos] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}
