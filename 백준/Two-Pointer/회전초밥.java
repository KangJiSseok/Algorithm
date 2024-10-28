import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 회전초밥 {

    static int[] rice;
    static int[] riceContain;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        rice = new int[d+1];
        riceContain = new int[N];

        for (int i = 0; i < N; i++) {
            riceContain[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (rice[riceContain[(start + i) % N]] == 0) {
                rice[riceContain[(start + i) % N]]++;
                count++;
            }else {
                rice[riceContain[(start + i) % N]]++;
            }
        }

        int max = count;

        while (start < N) {
            if (--rice[riceContain[start]] == 0) {
                count--;
            }

            if (rice[riceContain[(start + k) % N]]++ == 0) {
                count++;
            }

            start++;

            if (rice[c] == 0) {
                max = Math.max(count + 1, max);
            }else{
                max = Math.max(count, max);
            }
        }

        System.out.println(max);
    }
}
