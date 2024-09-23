import java.io.*;

public class 하노이탑이동순서 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solve(N, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void solve(int n, int start, int end, int transit) {
        count++;
        if (n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        solve(n - 1, start, transit, end);
        sb.append(start + " " + end + "\n");
        solve(n - 1, transit, end, start);
    }

}
