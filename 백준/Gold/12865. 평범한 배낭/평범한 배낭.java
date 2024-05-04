import java.util.*;
import java.io.*;


class Main{

    static int wight[];
    static int value[];
    static int[][] dp;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        wight = new int[N+1];
        value = new int[N+1];
        dp = new int[N+1][K+1];
        for(int i=1 ; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            wight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(wight[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j-wight[i]]+value[i], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // for(int i=1; i<=N; i++){
        //     System.out.println();
        //     for(int j=1; j<=K; j++){
        //         System.out.print(dp[i][j]+ " ");
        //     }
        // }

        System.out.print(dp[N][K]);
    }

}