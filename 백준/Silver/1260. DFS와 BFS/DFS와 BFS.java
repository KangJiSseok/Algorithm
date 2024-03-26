import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        int V = Integer.parseInt(st.nextToken()); // startVertex

        Graph graph = new Graph(N + 1); // 그래프 객체 생성

        //간선 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            graph.addEdge(source, destination);
        }


        graph.sort();

        // 인접한 정점들 출력
//        for (int i = 1; i <= N; i++) {
//            System.out.print("vertex "+i + ": ");
//            List<Integer> adjacentVertex = graph.getAdjacentVertiex(i);
//            for (Integer vertex : adjacentVertex) {
//                System.out.print(vertex + " ");
//            }
//            System.out.println();
//        }

        graph.dfs(V,sb);
        sb.setLength(0);
        graph.bfs(V,sb);

    }
}

// 그래프 클래스 정의
class Graph {
    private int vertex; // 노드(정점)의 개수
    private List<List<Integer>> adjacencyList; // 인접 리스트


    public void sort() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            Collections.sort(adjacencyList.get(i));
        }
    }

    // 그래프 생성자
    public Graph(int numVertices) {
        this.vertex = numVertices;
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
    public List<Integer> getAdjacentVertiex(int vertex) {
        return adjacencyList.get(vertex); // 주어진 정점에 인접한 정점들 반환
    }

    // BFS 메서드
    public void bfs(int startVertex, StringBuilder sb) {
        boolean[] visited = new boolean[vertex]; // 방문 여부를 나타내는 배열
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐

        visited[startVertex] = true; // 시작 정점을 방문했음을 표시
        queue.add(startVertex); // 시작 정점을 큐에 추가

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll(); // 큐에서 정점을 하나 꺼냄
            sb.append(currentVertex).append(" ");// 현재 정점 출력
            // 현재 정점의 인접한 정점들을 방문하고 큐에 추가
            for (int adjacentVertex : adjacencyList.get(currentVertex)) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true; // 인접한 정점을 방문했음을 표시
                    queue.add(adjacentVertex); // 인접한 정점을 큐에 추가
                }
            }
        }
        System.out.println(sb);
    }

    //DFS 메서드
    public void dfs(int startVertex, StringBuilder sb) {
        boolean[] visited = new boolean[vertex]; // 방문 여부를 나타내는 배열
        Stack<Integer> stack = new Stack<>(); // DFS를 위한 스택

        stack.push(startVertex); // 시작 정점을 스택에 추가

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop(); // 스택에서 정점을 하나 꺼냄
            if(visited[currentVertex]){
                continue;
            }else{
                visited[currentVertex] = true;
            }
            sb.append(currentVertex).append(" ");// 현재 정점 출력
            for (int i = adjacencyList.get(currentVertex).size() -1 ; i >= 0; i--) {
                int adjacentVertex = adjacencyList.get(currentVertex).get(i);
                if (!visited[adjacentVertex]) {
                    stack.push(adjacentVertex);
                }
            }
        }
        System.out.println(sb.toString());
    }
}