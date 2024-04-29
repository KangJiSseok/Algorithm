import java.util.*;
import java.io.*;
import java.lang.*;



class Main{
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = d(N);

        System.out.println(result);

    }

    static int d(int n){
        if(n==1){
            return 0;
        }
        if(n%6 ==0){
            if(dp[n] !=0) return dp[n];
            return dp[n] = Math.min(d(n/3),d(n/2)) + 1;
        }
        else if(n%3 ==0){
            if(dp[n] !=0) return dp[n];
            return dp[n] = Math.min(d(n/3), d(n-1)) + 1;
        }
        else if(n%2 ==0){
            if(dp[n] !=0) return dp[n];
            return dp[n] = Math.min(d(n/2), d(n-1)) +1;
        }
        else{
            if(dp[n] !=0) return dp[n];
            return dp[n] = d(n-1) +1;
        }

    }
}