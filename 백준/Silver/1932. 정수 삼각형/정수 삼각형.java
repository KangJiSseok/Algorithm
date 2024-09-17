import java.io.*;
import java.util.*;

public class Main {

    static int[][] triangle;
    static int n;

    static int max = 0;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(triangle[i], -1);
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int row, int column) {

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        if (row == n - 1) {
            return triangle[row][column];
        }


        int left = dfs(row + 1, column);
        int right = dfs(row + 1, column + 1);

        dp[row][column] = Math.max(left, right) + triangle[row][column];

        return dp[row][column];
    }
}
