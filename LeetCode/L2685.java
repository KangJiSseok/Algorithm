import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L2685 {
	public int countCompleteComponents(int n, int[][] edges) {

		boolean[] visited = new boolean[n];
		ArrayList<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			int s = edges[i][0];
			int e = edges[i][1];
			graph[s].add(e);
			graph[e].add(s);
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				int[] bfs = bfs(graph, visited, i);
				int vertexCount = bfs[0];
				int edgeCount = bfs[1];
				if(edgeCount == vertexCount * (vertexCount - 1)) result++;
			}
		}

		return result;
	}

	private int[] bfs(ArrayList<Integer>[] graph, boolean[] visited, int n) {
		int vertexCount = 1;
		int edgeCount = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while (!q.isEmpty()) {
			int vertex = q.poll();
			edgeCount += graph[vertex].size();
			for (Integer nVertex : graph[vertex]) {
				if(!visited[nVertex]){
					vertexCount++;
					q.add(nVertex);
					visited[nVertex] = true;
				}
			}
		}

		return new int[] {vertexCount, edgeCount};
	}
}
