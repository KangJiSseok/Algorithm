import java.io.*;

public class Main {

    static long[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int N = Integer.parseInt(br.readLine());
        dpArray = new long[N + 1];

        long result = dp(N);
        System.out.println(result);
    }

    static long dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;

        if(dpArray[n] != 0 ) return dpArray[n];
        return dpArray[n] = dp(n - 1) + dp(n - 2);
    }

}