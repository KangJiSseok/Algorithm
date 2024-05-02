import java.util.*;
import java.io.*;


class Main{

    static int[][] init;
    static int[][] dp;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        init = new int[2][100001];
        dp = new int[2][100001];
        //테스트 개수
        for(int i=1; i<= T; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<2 ;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=1; k<=n ;k++){
                    init[j][k] = Integer.parseInt(st.nextToken());
                    dp[j][k] = -1;
                }
            }

            dp[0][1] = init[0][1];
            dp[1][1] = init[1][1];
            dp[0][2] = dp[1][1] + init[0][2];
            dp[1][2] = dp[0][1] + init[1][2];

            int result = Math.max(topDown(0, n), topDown(1, n));
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int topDown(int y, int x){
        if(x <= 2 || dp[y][x] >= 0) return dp[y][x]; // 기존의 값이 있는 경우

        int temp = (y+1)%2;
        dp[y][x] = Math.max(topDown(temp, x-1), topDown(temp, x-2)) + init[y][x];

        return dp[y][x];
    }
}