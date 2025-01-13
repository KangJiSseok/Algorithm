import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max = 0;
        int even = 0;
        int odd = 0;

        while (right < N) {
            if (arr[right] % 2 == 0) {
                right++;
                even++;
                max = Math.max(max, even);
            }else{
                right++;
                odd++;
                if (odd > K) {
                    if (arr[left] % 2 == 0) {
                        while (arr[left] % 2 == 0) {
                            left++;
                            even--;
                        }
                        left++;
                        odd--;
                    }else{
                        left++;
                        odd--;
                    }
                }
            }
        }

        System.out.println(max);

    }
}

/**
 * k == 2 라고 할때,
 * 1    2   3   4   5   6   7   8
 * lr
 * lx   r
 * lx       xr
 * lx       x   r
 *      l   x   r
 *      l   x      xr
 *      l   x       x   r
 *              l   x   r
 *              l   x       xr
 *              l   x   r   x   r
 *
 *
 * k == 1일때
 * 1    2   4   5   6
 * lrx
 * lx   r
 * lx       r
 *      l   r
 *      l      xr
 *      l           r
 *
 */