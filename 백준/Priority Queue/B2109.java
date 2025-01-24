import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2109 {
	static boolean[] visited = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.p == o2.p) {
				if (o1.d < o2.d) {
					return Integer.compare(o1.d, o2.d);
				}
			}
			return Integer.compare(o2.p, o1.p);
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Node(p, d));
		}

		int result = 0;
		while (!pq.isEmpty()) {
			Node n = pq.poll();

			for (int i = n.d; i >= 1; i--) {
				if (!visited[i]) {
					visited[i] = true;
					result += n.p;
					break;
				}
			}
		}
		System.out.println(result);

	}

	static class Node {
		int p, d;

		public Node(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node{" +
				"p=" + p +
				", d=" + d +
				'}';
		}
	}
}
