import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < TestCase; i++) {

            int arrayLength = Integer.parseInt(br.readLine());
            int[][] graph = new int[arrayLength][arrayLength];
            
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startX, startY, endX, endY, arrayLength , graph, sb);
        }

        System.out.println(sb.toString());

    }

    static void bfs(int startX, int startY, int endX, int endY, int arrayLength, int[][] graph, StringBuilder sb) {
        Queue<int[]> queue = new LinkedList<>();
        graph[startX][startY] = 1;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            if (currentX == endX && currentY == endY) {
                sb.append(graph[currentX][currentY] -1).append("\n");
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + currentX;
                int ny = dy[i] + currentY;

                if (0 <= nx && nx < arrayLength && 0 <= ny && ny < arrayLength && graph[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny});
                    graph[nx][ny] = graph[currentX][currentY] + 1;
                }
            }
        }
    }
}
