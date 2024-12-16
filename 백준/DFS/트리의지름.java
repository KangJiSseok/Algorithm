import java.io.*;
import java.util.*;

public class 트리의지름 {
    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int maxSum = 0;
    static int maxNode = 1;

    static class Node {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        visit = new boolean[N+1];
        dfs(1, 0);

        visit = new boolean[N+1];
        maxSum = 0;
        dfs(maxNode, 0);

        System.out.println(maxSum);
    }

    static void dfs(int cur, int max) {
        visit[cur] = true;
        if (max > maxSum) {
            maxSum = max;
            maxNode = cur;
        }

        for (Node n : tree[cur]) {
            if (!visit[n.v]) {
                dfs(n.v, max + n.w);
            }
        }
    }
}
