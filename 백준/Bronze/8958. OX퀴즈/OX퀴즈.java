import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            String text = br.readLine();
            int sum =0;
            int plus = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == 'O') {
                    plus++;
                    sum += plus;
                }else{
                    plus = 0;
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());

    }
}



