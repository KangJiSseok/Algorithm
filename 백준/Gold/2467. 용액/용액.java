import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {

        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left =0;
        int right = arr.length-1;
        int beforeMax = Integer.MAX_VALUE;

        while (left < right) {
            int leftValue = arr[left];
            int rightValue = arr[right];
            int sum = leftValue + rightValue;
            int abs = Math.abs(sum);

            if (abs < beforeMax) {
                result[0] = leftValue;
                result[1] = rightValue;
                beforeMax = abs;
            }

            if (abs == 0) {
                result[0] = leftValue;
                result[1] = rightValue;
                break;
            } else if (sum < 0) {
                left = left + 1;
            } else if (sum > 0) {
                right = right - 1;
            }
        }

        sb.append(result[0] + " " + result[1]);
        System.out.println(sb);

    }
}