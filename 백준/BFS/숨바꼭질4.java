import java.util.*;
import java.io.*;

public class 숨바꼭질4 {
    static int[] visit = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(visit, -1);

        dfs(N, K);

        Stack<Integer> stack = new Stack<>();
        int child = K;
        while (child != N) {
            stack.push(child);
            child = parent[child];
        }
        stack.push(N);
        sb.append(visit[K]).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 0;
        while (!q.isEmpty()) {
            int pos = q.poll();
            if(pos == k) return;

            if (pos * 2 <= 100000 && visit[pos * 2] == -1) {
                visit[pos * 2] = visit[pos] + 1;
                parent[pos * 2] = pos;
                q.add(pos * 2);
            }

            if (pos - 1 >= 0 && visit[pos - 1] == -1) {
                visit[pos - 1] = visit[pos] + 1;
                parent[pos - 1] = pos;
                q.add(pos - 1);
            }

            if (pos + 1 <= 100000 && visit[pos + 1] == -1) {
                visit[pos + 1] = visit[pos] + 1;
                parent[pos + 1] = pos;
                q.add(pos + 1);
            }
        }
    }
}
