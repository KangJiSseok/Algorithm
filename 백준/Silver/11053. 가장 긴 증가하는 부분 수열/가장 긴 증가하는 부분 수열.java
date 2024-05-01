import java.util.*;
import java.io.*;
import java.lang.*;



class Main {

    static int[] init;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        init = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            init[i] = Integer.parseInt(st.nextToken());

        }


        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                
                if(init[j] < init[i] && dp[i] <dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

        }

        int max = -1;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max,dp[i]);
		}

        System.out.println(max);
    }
}