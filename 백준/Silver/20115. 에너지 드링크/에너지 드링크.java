import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static double sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] drink = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drink);

        sum = drink[N - 1];
        for (int i = 0; i < N - 1; i++) {
            sum = sum + ((double) drink[i] / 2);
        }

        System.out.println(sum);

    }
}
