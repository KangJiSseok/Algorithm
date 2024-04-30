import java.util.*;
import java.io.*;
import java.lang.*;



class Main{

    static int[] init;
    static int[] dp;

    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        init = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++){
            init[i] = Integer.parseInt(st.nextToken());
            dp[i] = init[i];
        }


        for(int i = 1 ; i<= N; i++){
            for(int j = 1; j < i; j++){
                if(init[i]> init[j]){
                    dp[i] = Math.max(dp[j]+init[i], dp[i]);
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}