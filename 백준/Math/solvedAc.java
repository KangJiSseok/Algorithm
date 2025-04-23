import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solvedAc {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int ceil = (int)Math.round(N * 0.15);

		double sum = 0;
		for (int i = ceil; i < N - ceil; i++) {
			sum += arr[i];
		}

		int avg = (int)Math.round(sum / (N - ceil * 2));
		System.out.println(avg);
	}
}
