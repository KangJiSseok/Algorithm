import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 곱셈 {

    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(dfs(B));

    }

    public static long dfs(int n) {

        if(n == 1) {
            return A % C;
        }

        long recursionValue = dfs(n / 2);

        if(n % 2 == 1) {
            return (recursionValue * recursionValue % C) * A % C;
        }
        return recursionValue * recursionValue % C;

    }
}
