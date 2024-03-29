import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] connectArray;
    static boolean[] connectVisit;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        connectArray = new int[N+1][N+1];
        connectVisit = new boolean[N + 1];


        Arrays.fill(connectVisit, false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            connectArray[x][y] = 1;
            connectArray[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dps(i);
        }

        System.out.println(count);
    }

    private static void dps(int startVertex) {
        if (!connectVisit[startVertex]) {
            connectVisit[startVertex] = true;
            count++;
        }

        for (int i = 1; i < connectArray[startVertex].length; i++) {
            if (!connectVisit[i] && connectArray[startVertex][i] == 1) {
                connectVisit[i] = true;
                dps(i);
            }
        }
    }
}