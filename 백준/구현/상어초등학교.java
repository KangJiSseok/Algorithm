import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 상어초등학교 {
    static int[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            map.put(num, list);

            boardPutValue(num);
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println();
//            for (int j = 0; j < N; j++) {
//                System.out.print(visit[i][j]);
//            }
//        }

        System.out.println(calculator());
    }

    private static void boardPutValue(int num) {
        ArrayList<Integer> loveList = map.get(num);
        int maxLove = -1;
        int maxEmptyCount = -1;
        int finalY = -1;
        int finalX = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] != 0) continue;
                int emptyCount = 0;
                int loveCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N) {
                        if (loveList.contains(visit[nextY][nextX])) loveCount++;
                        if (visit[nextY][nextX] == 0) emptyCount++;
                    }
                }
                if (maxLove < loveCount || (maxLove == loveCount && maxEmptyCount < emptyCount)) {
                    maxLove = loveCount;
                    maxEmptyCount = emptyCount;
                    finalY = i;
                    finalX = j;
                }

            }
        }
        visit[finalY][finalX] = num;
    }

    private static int calculator() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ArrayList<Integer> list = map.get(visit[i][j]);
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N) {
                        if(list.contains(visit[nextY][nextX])) count++;
                    }
                }
                switch (count) {
                    case 0 : result += 0; break;
                    case 1 : result += 1; break;
                    case 2 : result += 10; break;
                    case 3 : result += 100; break;
                    case 4 : result += 1000; break;
                }
            }
        }
        return result;
    }

}
