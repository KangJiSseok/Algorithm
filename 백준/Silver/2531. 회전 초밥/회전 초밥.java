import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] rice;
    static int[] variety;

    static int max = 0;

    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
        rice = new int[N];
        variety = new int[d + 1];
        for (int i = 0; i < N; i++) {
            rice[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < N; i++) {
            Arrays.fill(variety, 0);
            int count = 0;
            for (int j = 0; j < k; j++) {
                int pos = (i + j) % N;
                if (variety[rice[pos]] == 0) {
                    count++;
                    variety[rice[pos]]++;
                }else{
                    variety[rice[pos]]++;
                }

                if (variety[c] == 0) {
                    max = Math.max(max, count + 1);
                }else{
                    max = Math.max(max, count);
                }
            }

        }

        System.out.println(max);

    }
}