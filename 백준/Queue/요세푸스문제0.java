import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		sb.append("<");

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int count = 0;
		while (!q.isEmpty()) {

			if(count == K - 1){
				count = 0;
				Integer poll = q.poll();
				sb.append(poll).append(", ");
			}else{
				Integer poll = q.poll();
				q.add(poll);
				count++;
			}
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);

	}
}
