import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] countingArray = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int j = 1; j <= N; j++) {
            int numN = Integer.parseInt(br.readLine());
            countingArray[numN]++;
        }

        for (int i = 0; i < countingArray.length; i++) {
            while (countingArray[i] != 0) {
                sb.append(i).append("\n");
                countingArray[i]--;
            }
        }

        System.out.println(sb.toString());
    }
}
