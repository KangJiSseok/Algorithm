import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M, N;   //M = 조카의 수, N = 과자의 수
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] cookie = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cookie[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch(M, cookie);
        System.out.println(result);
    }

    static int binarySearch(int M, int[] cookie) {
        int left = 1;
        int right = 1000000000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < cookie.length; i++) {
                if (mid <= cookie[i]) {
                    count += (cookie[i] / mid);
                }
            }
            
            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else if(count < M){
                right = mid - 1;
            }
        }

        return result;
    }
}