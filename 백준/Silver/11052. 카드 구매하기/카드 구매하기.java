import java.util.*;
import java.io.*;
import java.lang.*;


class Main {

    static int[] P;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        int DP[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.max(DP[i], DP[i-j]+P[j]);
            }
        }

        System.out.println(DP[N]);
    }
}