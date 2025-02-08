import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	static int[][] arr;
	static int[][] sum;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sumFuntion();

		// System.out.println();
		// for (int i = 0; i <= N; i++) {
		// 	for (int j = 0; j <= N; j++) {
		// 		System.out.print(sum[i][j] +"   ");
		// 	}
		// 	System.out.println();
		// }

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int prefixSum = sum[x2][y2] - (sum[x2][y1 - 1] + sum[x1 - 1][y2]) + sum[x1 - 1][y1 - 1];
			sb.append(prefixSum).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void sumFuntion() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
	}
}
