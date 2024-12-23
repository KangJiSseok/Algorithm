import java.io.*;
import java.util.*;

public class 트리의지름2 {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int lastNode;

    static class Node {
        int n, v;
        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n;
            while ((n = Integer.parseInt(st.nextToken())) != -1) {
                int v = Integer.parseInt(st.nextToken());
                tree[s].add(new Node(n, v));
            }
        }

        visited[1] = true;
        dfs(1, 0);

        Arrays.fill(visited,false);

        visited[lastNode] = true;
        dfs(lastNode, 0);
        System.out.println(max);

    }

    private static void dfs(int n, int s) {
        if(s > max){
            max = s;
            lastNode = n;
        }
        for (int i = 0; i < tree[n].size(); i++) {
            Node node = tree[n].get(i);
            if(!visited[node.n]){
                visited[node.n] = true;
                dfs(node.n, s + node.v);
            }
        }
    }

}
