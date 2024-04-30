import java.util.*;
import java.io.*;
import java.lang.*;



class Main{
    static int[] dp = new int[1000001];
    
    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int result = d(N);

        System.out.println(result);

        pathSearch(N,sb);
        System.out.println(sb);


        // for(int i=1; i<=N; i++){
        //     System.out.print(dp[i] + " ");
        // }
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

    static void pathSearch(int n, StringBuilder sb){

        while(n>=1){
            if(n%6 ==0){
                int path = Math.min(dp[n/3],dp[n/2]);
                if(path == dp[n/3]) {
                    sb.append(n + " ");
                    n = n/3;
                }else{
                    sb.append(n + " ");
                    n = n/2;
                }
            }
            else if(n%3 ==0){
                int path = Math.min(dp[n/3],dp[n-1]);
                if(path == dp[n/3]) {
                    sb.append(n + " ");
                    n = n/3;
                }else{
                    sb.append(n + " ");
                    n = n-1;
                }
            }
            else if(n%2 ==0){
                int path = Math.min(dp[n/2],dp[n-1]);
                if(path == dp[n/2]) {
                    sb.append(n + " ");
                    n = n/2;
                }else{
                    sb.append(n + " ");
                    n = n-1;
                }
            }
            else{
                sb.append(n +" ");
                n = n-1;
            }
        }
    }
}