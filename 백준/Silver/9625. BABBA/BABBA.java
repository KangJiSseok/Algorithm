
import java.io.*;

class Main{

    static int[] dp;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        dp = new int[46];
        dp[1] = 1;
        dp[2] = 1;

        d(N);

        sb.append(dp[N-1]+ " ").append(dp[N]);

        System.out.println(sb);
        
    }

    static int d(int n){

        if(n == 1) return 1;
        if(n == 2) return 1;

        if(dp[n] != 0) return dp[n];

        return dp[n] = d(n-1) + d(n-2);
    }

}