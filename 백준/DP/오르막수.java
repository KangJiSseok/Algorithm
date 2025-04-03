import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[1001][10];

		Arrays.fill(arr[1], 1);
		for (int i = 0; i < 1001; i++) {
			arr[i][0] = 1;
		}

		for (int i = 2; i < 1001; i++) {
			for (int j = 1; j < 10; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1] % 10007;
			}
		}

		System.out.println(Arrays.stream(arr[N]).sum() % 10007);


	}
}
