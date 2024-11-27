import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] grade = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                grade[j][0] = Integer.parseInt(st.nextToken());
                grade[j][1] = Integer.parseInt(st.nextToken());

            }

            Arrays.sort(grade, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            int min = grade[0][1];
            int count = 1;
            for (int j = 1; j < N; j++) {
                if(min > grade[j][1]){
                    min = grade[j][1];
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
