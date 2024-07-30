import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) {
                union(a, b);
            }else{
                if (find(a) == find(b)) {
                    sb.append("YES" + "\n");
                }
                else{
                    sb.append("NO" + "\n");
                }
            }
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;
            }else {
                parent[a] = b;
            }
        }
    }
}