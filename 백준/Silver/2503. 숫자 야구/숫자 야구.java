import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] visit = new int[10];
    static int[] numberList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] number = new int[3];
    static List<String> permutationList = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        dfs(0);

        int N = Integer.parseInt(br.readLine());
        String[] otherNumber = new String[N];
        int[] strikeCountList = new int[N];
        int[] ballCountList = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            otherNumber[i] = st.nextToken();
            strikeCountList[i] = Integer.parseInt(st.nextToken());
            ballCountList[i] = Integer.parseInt(st.nextToken());
        }
        permutationList.forEach((value) -> {
            int[] strikeCount = new int[N];
            int[] ballCount = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    if (value.charAt(j)== otherNumber[i].charAt(j) ) {
                        strikeCount[i]++;
                    }
                    if (value.charAt(j) == otherNumber[i].charAt(((j + 1)) % 3) || value.charAt(j) == otherNumber[i].charAt(((j + 2)) % 3)) {
                        ballCount[i]++;
                    }
                }
            }


            int trueCount = 0;
            for (int i = 0; i < N; i++) {
                if (strikeCount[i] == strikeCountList[i] && ballCount[i] == ballCountList[i]) {
                    trueCount++;
                }

            }

            if (trueCount == N) {
                count++;
            }
        });

        System.out.println(count);

    }

    private static void dfs(int n) {
        if (n == 3) {
            String permutation = "";
            for (int value : number) {
                permutation += Integer.toString(value);
            }
            permutationList.add(permutation);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                number[n] = numberList[i];
                dfs(n + 1);
                visit[i] = 0;
            }
        }
    }
}
