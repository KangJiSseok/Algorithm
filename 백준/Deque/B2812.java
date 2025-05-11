import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = s.charAt(i) - '0';
		}

		Deque<Integer> d = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			while (K > 0 && !d.isEmpty() && d.peekLast() < arr[i]) {
				d.pollLast();
				K--;
			}
			d.addLast(arr[i]);
		}

		while (d.size() > K) {
			sb.append(d.pollFirst());
		}

		System.out.println(sb);
	}
}
