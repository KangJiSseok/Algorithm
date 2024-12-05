import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class 상범빌딩 {

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, -1, 1, 0, 0, 0};
    static int[] dx = {-1, 0, 0, 1, 0, 0};
    static Character[][][] board;
    static int[][][] visit;
    static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) {
                break;
            }

            board = new Character[L][R][C];
            visit = new int[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    Arrays.fill(visit[i][j], -1);
                }
            }
            int[] S = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = line.charAt(k);
                        if (c == 'S') {
                            S[0] = i;
                            S[1] = j;
                            S[2] = k;
                            board[i][j][k] = 'S';
                        } else {
                            board[i][j][k] = c;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(S[0], S[1], S[2]);

            if (result == -1) {
                sb.append("Trapped!\n");
            }else{
                sb.append("Escaped in " + result + " minute(s).\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int sz, int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sz, sy, sx});
        visit[sz][sy][sx] = 0;
        int z, y, x, nz, ny, nx;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            z = poll[0];
            y = poll[1];
            x = poll[2];
            if(board[z][y][x] == 'E') return visit[z][y][x];
            for (int i = 0; i < 6; i++) {
                nz = z + dz[i];
                ny = y + dy[i];
                nx = x + dx[i];

                if (0 <= nz && nz < L
                        && 0 <= ny && ny < R
                        && 0 <= nx && nx < C
                        && visit[nz][ny][nx] == -1
                ) {
                    if(board[nz][ny][nx] == '.'){
                        visit[nz][ny][nx] = visit[z][y][x] + 1;
                        q.add(new int[]{nz, ny, nx});
                    }else if(board[nz][ny][nx] == 'E'){
                        visit[nz][ny][nx] = visit[z][y][x] + 1;
                        q.add(new int[]{nz, ny, nx});
                    }
                }
            }
        }
        return -1;
    }
}
