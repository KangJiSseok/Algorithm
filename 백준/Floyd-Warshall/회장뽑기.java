import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 회장뽑기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(arr[i], 100000);
		}
		int a, b;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			arr[i][i] = 0;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int curMax = 0;
			for (int j = 1; j <= N; j++) {
				curMax = Math.max(arr[i][j], curMax);
			}

			if (min < curMax) {
				continue;
			}else if (min == curMax){
				list.add(i);
			}else{
				list = new ArrayList<>();
				list.add(i);
				min = curMax;
			}
		}

		sb.append(min + " " + list.size()).append("\n");
		for (Integer integer : list) {
			sb.append(integer + " ");
		}

		System.out.println(sb.toString());
	}
}
