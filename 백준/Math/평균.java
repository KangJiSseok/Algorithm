import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());

		int max = -1;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		double result = 0;
		for (int i = 0; i < N; i++) {
			result += (double) arr[i] / max * 100;
		}

		System.out.println(result / N);


	}
}
