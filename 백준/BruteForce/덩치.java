import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
			}
			arr[i][2] = count + 1;
		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i][2] + " ");
		}

		System.out.println(sb);

	}
}
