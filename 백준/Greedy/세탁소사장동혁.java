import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int price = Integer.parseInt(br.readLine());
            int q = price / 25;
            price %= 25;
            int d = price / 10;
            price %= 10;
            int n = price / 5;
            price %= 5;
            int p = price / 1;
            sb.append(q + " " + d + " " + n + " " + p).append("\n");
        }
        System.out.println(sb.toString());

    }
}
