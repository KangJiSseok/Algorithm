import java.io.*;
import java.util.*;

public class 합이0 {

    static int[] p;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        long result = 0;

        for (int i = 0; i < N; i++) {
            int t = -p[i];
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                int sum = p[l] + p[r];
                if(sum < t) l++;
                else if(sum > t) r--;
                else{
                    if (p[l] == p[r]) {
                        int count = r - l + 1;
                        result += (long) count * (count - 1) / 2;
                        break;
                    } else {
                        int lv = p[l];
                        int rv = p[r];
                        int lc = 0;
                        int rc = 0;
                        while (l <= r && p[l] == lv) {
                            lc++;
                            l++;
                        }
                        while (l <= r && p[r] == rv) {
                            rc++;
                            r--;
                        }
                        result += (long) lc * rc;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

