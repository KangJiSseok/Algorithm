import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class Main {
    static int count = 1;

    static int a;
    static int b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        while (true) {

            a = Integer.parseInt(A);
            b = Integer.parseInt(B);
            if (a > b) {
                System.out.println(-1);
                break;
            }
            if (a==b) {
                System.out.println(count);
                break;
            }
            if (B.charAt(B.length() - 1) == '1') {
                B = B.substring(0, B.length() - 1);
                count++;
            } else if(b % 2 == 0) {
                b = b / 2;
                B = String.valueOf(b);
                count++;
            } else {
                System.out.println(-1);
                break;
            }

        }
    }
}
