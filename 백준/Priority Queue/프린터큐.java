import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 찾고자 하는 문서의 위치

			Queue<Main.Node> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.offer(new Main.Node(i, priority));
				pq.offer(priority);
			}

			int count = 0;
			while(true){
				int peek = pq.peek();
				Main.Node poll = q.poll();
				if(poll.priority < peek){
					q.add(poll);
				} else if (poll.priority == peek) {
					count++;
					if(poll.index == M){
						sb.append(count).append("\n");
						break;
					}
					pq.poll();
				}else{
					//케이스 존재 x
					continue;
				}
			}
		}
		System.out.print(sb);
	}


	static class Node {
		int index, priority;

		public Node(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
}
