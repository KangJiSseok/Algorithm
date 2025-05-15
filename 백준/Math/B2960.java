import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int result = 0;
		boolean[] arr = new boolean[N + 1];

		for (int i = 2; i <= N ; i++) {
			if (!arr[i]) {
				for (int j = i; j <= N; j += i) {
					if(!arr[j]){
						arr[j] = true;
						result++;
					}

					if(result == K){
						System.out.println(j);
						return;
					}
				}
			}
		}

	}
}
