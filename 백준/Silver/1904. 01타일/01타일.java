import java.util.*;
import java.io.*;

class Main{

    static int[] d;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        d = new int[N+1];

        int count = dp(N);

        System.out.println(count);

    }

    private static int dp(int x){

        if(x == 1) return 1;
        if(x == 2) return 2;
        
        if(d[x] !=0) return d[x];
        return d[x] = (dp(x-1) + dp(x-2))%15746; 

    }
}