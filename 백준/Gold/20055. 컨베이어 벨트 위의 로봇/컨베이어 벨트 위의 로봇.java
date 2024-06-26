import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        int step = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[N * 2];
        boolean[] robot = new boolean[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;

        while (K > 0) {
            step++;

            // step 1 벨트를 회전하자.
            start = (start - 1) < 0 ? (2 * N) - 1 : start - 1;
            end = (end - 1) < 0 ? (2 * N) - 1 : end - 1;
            robot[end] = false;

            int current = end;
            // step 2 역순으로 로봇 이동
            for (int i = 1; i < N; i++) {
                current = (current - 1) < 0 ? (2 * N) - 1 : current - 1;
                int nextIndex = (current + 1) % (2 * N);
                if (!robot[nextIndex] && belt[nextIndex] > 0 && robot[current]) {
                    robot[current] = false;
                    robot[nextIndex] = true;
                    if (--belt[nextIndex] == 0) K--;
                }
            }

            robot[end] = false;

            //step 3 로봇 탑승
            if (belt[start] > 0) {
                robot[start] = true;
                if (--belt[start] == 0) K--;
            }
        }

        System.out.println(step);
    }
}
