import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] travel;
    static boolean result = true;

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        travel = new int[M];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int child = Integer.parseInt(st.nextToken());
                if (child == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M - 1; i++) {
            if (find(travel[i]) != find(travel[i + 1])) {
                result = false;
                break;
            }
        }

        if (result == false) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}