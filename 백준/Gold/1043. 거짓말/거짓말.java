import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p = new int[51];
    static int[][] party = new int[51][52];
    static boolean[] truth = new boolean[51];

    public static int find(int c) {
        if (p[c] == c) {
            return c;
        }
        return p[c] = find(p[c]);
    }

    public static void merge(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (truth[p1]) {
            p[p2] = p1;
        } else {
            p[p1] = p2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(st.nextToken());
            truth[n] = true;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
                merge(party[i][0], party[i][j]);
            }
        }

        int ans = M;
        for (int i = 0; i < M; i++) {
            if (truth[find(party[i][0])]) {
                ans--;
            }
        }

        System.out.println(ans);
    }
}
