import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pakageMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pakageMin = Math.min(pakageMin, Integer.parseInt(st.nextToken()));
            min = Math.min(min, Integer.parseInt(st.nextToken()));
        }
        /**
         * 경우의수
         * only 패키지
         * 패키지 + 낯개
         * only 낯개
         */

        int one = 0;
        one = (N % 6) == 0 ? (N / 6) * pakageMin : (N / 6) * pakageMin + pakageMin;

        int two = 0;
        two = (N % 6) == 0 ? (N / 6) * pakageMin : (N / 6) * pakageMin + (N % 6) * min;

        int three = 0;
        three = N * min;

        System.out.println(Math.min(Math.min(one, two), three));

    }
}
