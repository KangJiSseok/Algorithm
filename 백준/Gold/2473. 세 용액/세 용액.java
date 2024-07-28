import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static long[] arr;
    static long[] result;

    public static void main(String[] args) throws Exception {

        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        result = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long beforeMax = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            long leftValue = arr[i];
            int mid = i + 1;
            int right = arr.length - 1;
            while (mid < right) {
                long midValue = arr[mid];
                long rightValue = arr[right];
                long sum = leftValue + midValue + rightValue;
                long abs = Math.abs(sum);

                if (abs < beforeMax) {
                    result[0] = leftValue;
                    result[1] = midValue;
                    result[2] = rightValue;
                    beforeMax = abs;
                }

                if (abs == 0) {
                    result[0] = leftValue;
                    result[1] = midValue;
                    result[2] = rightValue;
                    break;
                } else if (sum < 0) {
                    mid = mid + 1;
                } else if (sum > 0) {
                    right = right - 1;
                }
            }

        }

        sb.append(result[0] + " " + result[1] + " " + result[2]);
        System.out.println(sb);

    }
}