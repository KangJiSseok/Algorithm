import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] size = new int[6];

        int N = Integer.parseInt(br.readLine());
        int T = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 6; i++) {
            T += (size[i] + a - 1) / a;
        }
        sb.append(T + "\n");
        sb.append(N / b + " " + N % b);

        System.out.println(sb.toString());

    }
}
