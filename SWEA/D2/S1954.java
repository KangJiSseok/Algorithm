import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1954 {
	static int count = 0;
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int k = 1;
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			count = 1;

			dfs(0, N - 1);
			sb.append("#").append(k++).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void dfs(int s, int e) {

		if(e - s == 0){
			arr[e][s] = count;
			return;
		}
		if (e - s < 0) {
			return;
		}

		for (int i = s; i < e; i++) {
			arr[s][i] = count++;
		}

		for (int i = s; i < e; i++) {
			arr[i][e] = count++;
		}

		for (int i = e; i > s; i--) {
			arr[e][i] = count++;
		}

		for (int i = e; i > s; i--) {
			arr[i][s] = count++;
		}

		dfs(s + 1, e - 1);
	}
}
