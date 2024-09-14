import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> map = new ArrayList<>(N);

        boolean[] visited = new boolean[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : map.get(parent)) {
                if (!visited[child]) {
                    visited[child] = true;
                    result[child] = parent + 1;
                    queue.add(child);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
