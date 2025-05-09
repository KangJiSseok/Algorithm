import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1859 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int k = 1;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = arr[N - 1];
			long result = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (max > arr[i]) {
					result += max - arr[i];
				}else{
					max = arr[i];
				}
			}

			sb.append("#").append(k++).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}
}
