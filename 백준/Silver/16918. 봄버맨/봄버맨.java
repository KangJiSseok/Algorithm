import java.util.*;
import java.io.*;

public class Main {

    static int[][][] bomb;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // [][][0] = 1 인 경우 : .     폭탄이 아닌경우
        // [][][0] = 0 인 경우 : 0     폭탄인 경우
        // [][][1] = -1 인 경우        타이머 제거
        // [][][1] = 3 인 경우         타이머 3초
        bomb = new int[R][C][2];

        for (int i = 0; i < R; i++) {
            String bombList = br.readLine();
            for (int j = 0; j < C; j++) {
                if (bombList.charAt(j) == '.') {
                    bomb[i][j][0] = 1;
                    bomb[i][j][1] = -1;
                } else {
                    bomb[i][j][0] = 0;
                    bomb[i][j][1] = 3;
                }
            }
        }

        for (int t = 1; t <= N; t++) {

            if (t % 2 == 0) {
                // 폭탄 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bomb[i][j][0] == 1) { //폭탄이 아닌 경우 폭탄 설치
                            bomb[i][j][0] = 0;
                            bomb[i][j][1] = 3; // timer 셋팅
                        } else if (bomb[i][j][0] == 0) {    //폭탄인 경우
                            bomb[i][j][1]--; // 기존 폭탄 timer시간 감소
                        }
                    }
                }
            } else {
                // 폭탄 터짐 && 안터지는 다른 폭탄 타이머 감소
                List<int[]> bombList = new ArrayList<>();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bomb[i][j][0] == 0) {   //폭탄인 경우
                            bomb[i][j][1]--; // 타이머 감소
                            if (bomb[i][j][1] == 0) {   //남은시간이 0초인 경우
                                bombList.add(new int[]{i, j});
                            }
                        }
                    }
                }
                // 폭발물 처리 상하좌우
                for (int[] pos : bombList) {
                    int i = pos[0];
                    int j = pos[1];
                    bomb[i][j][0] = 1;      // 폭발한 자리는 1로 셋팅
                    bomb[i][j][1] = -1;     //타이머 제거
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            bomb[nx][ny][0] = 1;    // 상하좌우 폭탄 1로 셋팅
                            bomb[nx][ny][1] = -1;   // 타이머 제거
                        }
                    }
                }
            }

//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(bomb[i][j][0] + " ");
//                }
//                System.out.print("        ");
//                for (int j = 0; j < C; j++) {
//                    System.out.print(bomb[i][j][1] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(bomb[i][j][0] == 0){
                    sb.append("O");
                }else{
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

