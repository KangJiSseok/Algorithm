import java.util.*;

class L2684 {
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    public int maxMoves(int[][] grid) {
        int[][] visit = new int[grid.length][grid[0].length];
        int max = 0;

        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i< grid.length; i++){
            q.add(new int[]{i,0});
        }

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for(int i=0; i<3 ; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(0<=ny && ny<grid.length && 0<=nx && nx < grid[0].length){
                    if(visit[ny][nx] == 0 && grid[ny][nx] > grid[y][x]){
                        visit[ny][nx] = visit[y][x] + 1;
                        q.add(new int[]{ny,nx});
                        max = Math.max(max,visit[ny][nx]);
                    }
                }
            }
        }

        return max;
    }
}