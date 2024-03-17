import java.io.*;
import java.util.*;


public class Main {

    static int[] arr = new int[10001];
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //사전 작업
        int N = Integer.parseInt(br.readLine());
        int[] locationBudget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            locationBudget[i] = Integer.parseInt(st.nextToken());
        }
        int budget = Integer.parseInt(br.readLine());
        //사전 작업 끝

        Arrays.sort(locationBudget);
        int start = 0;
        int end = locationBudget[N - 1];

        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                sum += Math.min(mid, locationBudget[i]);
            }

            // 예산의 총 합이 budget을 넘지 않으면
            if (sum <= budget) {
                answer = mid;
                start = mid + 1;
            } else {
                // 예산이 넘을 경우
                end = mid - 1;
            }
        }

        System.out.println(answer);
        
    }
}