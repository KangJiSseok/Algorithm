import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] building;
    static int[][] personVisit;
    static int[][] fireVisit;
    static Queue<int[]> fireQueue;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        int iter = Integer.parseInt(br.readLine());

        for (int i = 0; i < iter; i++) {
            solution();
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static void solution() throws IOException {
        // 초기화
        fireQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        building = new char[h][w];
        personVisit = new int[h][w];
        fireVisit = new int[h][w];
        int startX = -1, startY = -1;

        for (int i = 0; i < h; i++) {
            String text = br.readLine();
            for (int j = 0; j < w; j++) {
                building[i][j] = text.charAt(j);
                if (building[i][j] == '*') {
                    fireQueue.add(new int[]{i, j});
                    fireVisit[i][j] = 1;
                } else if (building[i][j] == '@') {
                    startY = i;
                    startX = j;
                    personVisit[i][j] = 1;
                }
            }
        }

        int result = bfs(h, w, startY, startX);
        if (result == -1) {
            sb.append("IMPOSSIBLE\n");
        } else {
            sb.append(result+"\n");
        }
    }

    private static int bfs(int h, int w, int startY, int startX) {
        Queue<int[]> personQueue = new LinkedList<>();
        personQueue.add(new int[]{startY, startX});

        while (!personQueue.isEmpty()) {
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                int[] firePos = fireQueue.poll();
                int fireY = firePos[0];
                int fireX = firePos[1];
                for (int j = 0; j < 4; j++) {
                    int nextFireY = fireY + dy[j];
                    int nextFireX = fireX + dx[j];
                    if (0 <= nextFireY && nextFireY < h && 0 <= nextFireX && nextFireX < w) {
                        if (building[nextFireY][nextFireX] != '#' && fireVisit[nextFireY][nextFireX] == 0) {
                            fireQueue.add(new int[]{nextFireY, nextFireX});
                            fireVisit[nextFireY][nextFireX] = 1;
                        }
                    }
                }
            }

            int personSize = personQueue.size();
            for (int i = 0; i < personSize; i++) {
                int[] personPos = personQueue.poll();
                int personY = personPos[0];
                int personX = personPos[1];
                for (int j = 0; j < 4; j++) {
                    int nextPersonY = personY + dy[j];
                    int nextPersonX = personX + dx[j];
                    if (nextPersonY < 0 || nextPersonY >= h || nextPersonX < 0 || nextPersonX >= w) {
                        return personVisit[personY][personX];
                    }
                    if (building[nextPersonY][nextPersonX] == '.' && personVisit[nextPersonY][nextPersonX] == 0) {
                        if (fireVisit[nextPersonY][nextPersonX] == 0) {
                            personQueue.add(new int[]{nextPersonY, nextPersonX});
                            personVisit[nextPersonY][nextPersonX] = personVisit[personY][personX] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
