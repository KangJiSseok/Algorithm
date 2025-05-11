import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S23791 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[N + 1];
			char[] result = new char[N + 1];

			Queue<Integer> aq = new LinkedList<>();
			Queue<Integer> bq = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				aq.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				bq.add(Integer.parseInt(st.nextToken()));
			}

			int count = 0;
			while (count <= N) {

				if(arr[aq.peek()] && count < N){
					while(arr[aq.peek()]){
						aq.poll();
					}
				}
				Integer ap = aq.poll();
				arr[ap] = true;
				result[ap] = 'A';
				count++;
				if(count == N) break;

				if(arr[bq.peek()] && count < N){
					while(arr[bq.peek()]){
						bq.poll();
					}
				}
				Integer bp = bq.poll();
				arr[bp] = true;
				result[bp] = 'B';
				count++;
				if(count == N) break;
			}

			for (int i = 1; i <= N; i++) {
				sb.append(result[i]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
