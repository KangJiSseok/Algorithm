import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for (int j = 0; j < text.length(); j++) {
                for (int k = 0; k < iter; k++) {
                    sb.append(text.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}



