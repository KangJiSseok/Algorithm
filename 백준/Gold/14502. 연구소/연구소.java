import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int[][] room;
    static int N;
    static int M;
    static int[][] roomVisit;
    static int[][] wall = new int[3][2];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int max = 0;
    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        roomVisit = new int[N][M];

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
        
    }

    static void dfs(int depth){

        if(depth == 3){
//            System.out.println(wall[0][0]+ " " + wall[0][1] + " " + wall[1][0] + " " + wall[1][1] + " " + wall[2][0] + " " + wall[2][1]);
            int[][] tempArray = temp();
            bfs(tempArray);
            return;
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(roomVisit[i][j] == 0 && room[i][j] == 0){
                    roomVisit[i][j] = 1;
                    wall[depth] = new int[]{i,j};
                    dfs(depth + 1);
                    roomVisit[i][j] = 0;
                }
            }
        }
    }

    static void bfs(int[][] array){
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(array[i][j] == 2){
                    queue.add(new int[]{i,j});
                    visit[i][j] = 1;
                }else if(array[i][j] == 1){
                    visit[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for(int i=0; i<4; i++){
                int nextY = poll[0] + dy[i];
                int nextX = poll[1] + dx[i];

                if(0<=nextY && nextY< N && 0 <=nextX && nextX < M && visit[nextY][nextX] == 0){
                    if(array[nextY][nextX] == 0){
                        queue.add(new int[]{nextY, nextX});
                        visit[nextY][nextX] = 1;
                    }
                }
            }
        }

        max = Math.max(count(visit),max);

    }

    static int count(int[][] visit){
        int count =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visit[i][j] == 0) count++;
            }
        }
        return count;
    }

    static int[][] temp(){
        int[][] newArray = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                newArray[i][j] = room[i][j];
            }
        }

        for(int i=0; i<3; i++){
            newArray[wall[i][0]][wall[i][1]] = 1;
        }

        return newArray;
    }
}