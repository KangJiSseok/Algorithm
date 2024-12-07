import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class L2290 {
    public int minimumObstacles(int[][] grid) {

        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];

        for(int i=0; i<grid.length; i++){
            Arrays.fill(visit[i], -1);
        }

        Deque<int[]> d = new LinkedList<>();
        d.addFirst(new int[]{0,0});//y,x
        visit[0][0] = 0;

        while(!d.isEmpty()){
            int[] poll =d.pollFirst();
            if(poll[0] == n-1 && poll[1] == m-1) break;
            for(int i=0; i<4; i++){
                int nY = poll[0] + dy[i];
                int nX = poll[1] + dx[i];

                if(nY <0 || nY >=n || nX < 0 || nX >= m) continue;

                if(grid[nY][nX] == 0 && visit[nY][nX] == -1){
                    visit[nY][nX] = visit[poll[0]][poll[1]];
                    d.addFirst(new int[]{nY,nX});
                }else if(grid[nY][nX] == 1 && visit[nY][nX] == -1){
                    visit[nY][nX] = visit[poll[0]][poll[1]] + 1;
                    d.addLast(new int[]{nY,nX});
                }
            }
        }
        return visit[n-1][m-1];
    }
}