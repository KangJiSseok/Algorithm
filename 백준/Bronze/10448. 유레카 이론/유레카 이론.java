import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int[] gaussList = new int[45];

        for (int i = 1; i <= 44; i++) {
            gaussList[i] = t(i);
        }

        for (int q = 0; q < testCase; q++) {
            int boolean1 = extracted(br, gaussList);

            if (boolean1 == 1) {
                sb.append(1).append("\n");
            }else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static int extracted(BufferedReader br, int[] gaussList) throws IOException {
        int value = Integer.parseInt(br.readLine());

        int a;
        int b;
        int c;
        for (int i = 1; i <= 44; i++) {
            a = gaussList[i];
            for (int j = 1; j <= 44; j++) {
                b = gaussList[j];
                for (int k = 1; k <= 44; k++) {
                    c = gaussList[k];
                    if (a + b + c == value) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    static int t(int n) {
        return (n* (n + 1) / 2);
    }
}
