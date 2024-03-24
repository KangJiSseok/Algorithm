import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numVertices = Integer.parseInt(br.readLine()); //노드의 개수
        int numEdge = Integer.parseInt(br.readLine()); //간선의 개수
        Graph graph = new Graph(numVertices + 1); // 그래프 객체 생성

        //간선 추가
        for (int i = 1; i <= numEdge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            graph.addEdge(source, destination);
        }

        // 인접한 정점들 출력
//        for (int i = 1; i < numVertices; i++) {
//            System.out.print("Adjacent to " + i + ": ");
//            List<Integer> adjacentVertices = graph.getAdjacentVertices(i);
//            for (Integer vertex : adjacentVertices) {
//                System.out.print(vertex + " ");
//            }
//            System.out.println();
//        }

        // BFS 실행
//        System.out.println("BFS traversal:");
        graph.bfs(1); // 시작 정점을 1로 설정
    }
}

// 그래프 클래스 정의
class Graph {
    private int numVertices; // 노드(정점)의 개수
    private List<List<Integer>> adjacencyList; // 인접 리스트

    // 그래프 생성자
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        // 인접 리스트 초기화
        for (int i = 0; i <= numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // 간선 추가 메서드
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination); // source와 destination 사이에 간선 추가
        adjacencyList.get(destination).add(source); // destination과 source 사이에 간선 추가 (양방향 그래프인 경우)
    }

    // 인접한 정점들 반환 메서드
    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex); // 주어진 정점에 인접한 정점들 반환
    }

    // BFS 메서드
    public void bfs(int startVertex) {
        int numBFS = 0;
        boolean[] visited = new boolean[numVertices + 1]; // 방문 여부를 나타내는 배열
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐

        visited[startVertex] = true; // 시작 정점을 방문했음을 표시
        queue.add(startVertex); // 시작 정점을 큐에 추가

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // 큐에서 정점을 하나 꺼냄
//            System.out.print(currentVertex + " "); // 현재 정점 출력

            // 현재 정점의 인접한 정점들을 방문하고 큐에 추가
            for (int adjacentVertex : adjacencyList.get(currentVertex)) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true; // 인접한 정점을 방문했음을 표시
                    queue.add(adjacentVertex); // 인접한 정점을 큐에 추가
                    ++numBFS;
                }
            }
        }
        System.out.println(numBFS);
    }
}
