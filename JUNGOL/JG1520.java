import java.util.*;
import java.io.*;


public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int arr[] = new int[301];
    static int dp[][] = new int[301][2];

    static int N;

    public static void main(String args[]) throws IOException{

        N = Integer.parseInt(br.readLine());
        for(int i =1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = arr[1];        
        for(int i = 2; i<= N; i++){
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}