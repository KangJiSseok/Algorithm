import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Long> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long a = pq.poll() + pq.poll();
			pq.add(a);
			pq.add(a);
		}

		int size = pq.size();
		long sum = 0;
		for (int i = 0; i < size; i++) {
			sum += pq.poll();
		}

		System.out.println(sum);
	}
}
