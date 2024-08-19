import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] d;

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int value = Integer.parseInt(br.readLine());
            d = new int[value + 1];
            System.out.println(dp(value));
        }
    }

    private static int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (d[n] != 0) return d[n];

        return d[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
    }

}