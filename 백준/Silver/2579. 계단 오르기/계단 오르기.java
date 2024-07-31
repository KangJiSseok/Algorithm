import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result = 0;
    static int[] array;
    static int[] dp;

    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        if (N >= 2) {
            dp[2] = array[2] + array[1];
        }
        dp[1] = array[1];
        dp[0] = array[0];
        System.out.println(d(N));
    }

    static int d(int x) {
        if (dp[x] != 0) return dp[x];
        if(x >= 3){
            return dp[x] = Math.max(d(x - 2), array[x - 1] + d(x - 3)) + array[x];
        }
        return dp[x];
    }
}