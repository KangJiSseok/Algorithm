import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;

		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] >= arr[i + 1]) {
				int minus = arr[i] - arr[i + 1] + 1;
				arr[i] -= minus;
				result += minus;
			}
		}
		System.out.println(result);
	}
}
