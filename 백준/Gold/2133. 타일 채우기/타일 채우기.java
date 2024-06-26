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

        if( x== 0) return 1;
        if( x== 1) return 0;
        if( x== 2) return 3;

        if(d[x] !=-0) return d[x];

        int result = 3* dp(x-2);

        for(int i=3; i<=x ; i++){
            if(i%2 == 0) result += 2* dp(x-i);
        }


        return d[x] = result;
    }
}