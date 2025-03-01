import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] arr = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = br.readLine();
		}

		List<List<Integer>> graph = new ArrayList<>();
		//0번째 인덱스 = null로 초기화
		graph.add(new ArrayList<>());

		//1번째 인덱스부터 넣기
		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 1; j <= N; j++) {
				int count = 0;
				for (int k = 0; k < K; k++) {
					if (arr[i].charAt(k) != arr[j].charAt(k)) {
						count++;
					}
				}
				if(count == 1) list.add(j);
			}
			graph.add(list);
		}

		// for (int i = 1; i < graph.size(); i++) {
		// 	List<Integer> integers = graph.get(i);
		// 	System.out.print(i +"번째 =  ");
		// 	for (Integer integer : integers) {
		// 		System.out.print(integer + " ");
		// 	}
		// 	System.out.println();
		// }

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(S, String.valueOf(S) + " "));
		visited[S] = true;


		while (!q.isEmpty()) {
			Node poll = q.poll();
			if (poll.index == E) {
				System.out.println(poll.path);
				return;
			}

			List<Integer> onePath = graph.get(poll.index);

			for (int i = 0; i < onePath.size(); i++) {
				if (!visited[onePath.get(i)]) {
					visited[onePath.get(i)] = true;
					q.add(new Node(onePath.get(i), poll.path + onePath.get(i) + " "));
				}
			}

		}

		System.out.println(-1);
	}

	static class Node{
		int index;
		String path;

		public Node(int index, String path) {
			this.index = index;
			this.path = path;
		}
	}
}
