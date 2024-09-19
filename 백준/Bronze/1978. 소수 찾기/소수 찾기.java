import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int result = 0;
        int[] arr = new int[1001];

        for (int i = 2; i < arr.length; i++) {
            for (int j = i; j < arr.length; j = j + i) {
                arr[j]++;
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (arr[Integer.parseInt(st.nextToken())] == 1) {
                result++;
            }
        }

        System.out.println(result);

    }
}
