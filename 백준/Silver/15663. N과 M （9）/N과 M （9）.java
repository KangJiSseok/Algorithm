import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] visit;
    static int[] result;
    static int N;
    static int M;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new int[N];

        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int index, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            set.add(String.valueOf(sb));
            sb.setLength(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                result[index] = arr[i];
                dfs(index + 1, depth + 1);
                visit[i] = 0;
            }
        }

    }

}
