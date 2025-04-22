import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M, N;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[1000001];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (arr[i])
				continue;
			for (int j = i * i; j <= 1000000; j += i) {
				arr[j] = true;
			}
		}

		for (int i = M; i <= N; i++) {
			if (!arr[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb);
	}
}
