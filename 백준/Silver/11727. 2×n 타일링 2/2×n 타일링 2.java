import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] Rectangle = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = dp(N);
        System.out.println(result);
    }

    static private int dp(int n) {
        if(n == 1) return 1;
        if(n == 2) return 3;
        if(Rectangle[n] != 0) return Rectangle[n];
        return Rectangle[n] = (dp(n - 1) + 2*dp(n - 2)) % 10007;
    }
}