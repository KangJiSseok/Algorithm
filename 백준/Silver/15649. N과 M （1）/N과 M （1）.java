import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] visit;
    static int[] result;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visit = new int[N];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                result[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = 0;
            }
        }

    }
}
