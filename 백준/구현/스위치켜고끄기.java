import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int P = Integer.parseInt(br.readLine());
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(s == 1) man(n);
			else woman(n);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + " ");
			if(i%20 == 0) sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void man(int n) {
		for (int i = n; i <= N; i += n) {
			arr[i] ^= 1;
		}
	}

	private static void woman(int n) {
		arr[n] ^= 1;
		for (int i = 1; i <= n; i++) {
			if(1 <= n - i && n + i <= N){
				if(arr[n - i] == arr[n + i]){
					arr[n - i] ^= 1;
					arr[n + i] ^= 1;
				}
				else return;

			}else return;
		}
	}
}
