import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리 {
    static int[][] node;
    static int[] visit;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        node = new int[N][N];
        visit = new int[N];
        ArrayList<Integer> root = new ArrayList<>();

        st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == -1) root.add(i);
            else node[value][i] = 1;
        }

        int removeNode = Integer.parseInt(br.readLine());

        if (root.contains(removeNode)) {
            root.remove((Integer)removeNode);
        }


        for (int i = 0; i <  N; i++) {
            node[removeNode][i] = 0;
            node[i][removeNode] = 0;
        }

        for (int r : root) {
            visit[r] = 1;
            dfs(r);
        }


        System.out.println(result);

    }

    private static void dfs(int p) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (node[p][i] == 1 && visit[i] == 0) {
                count++;
                visit[i] = 1;
                dfs(i);
            }
        }

        if (count == 0) {
            result++;
        }
    }

}
