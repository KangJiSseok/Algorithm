import java.util.*;
import java.io.*;
import java.lang.*;

/*
    1. 컨베이어 벨트 1칸 회전
        - N번째 칸에 로봇이 있는지 확인 (있으면 로봇 삭제)
    2. 가장 먼저 올라간 로봇부터 1칸씩 회전 (N+1이 내구도 0이상 && 로봇 없어야함)
        - N-1, N-2 … 1 순차적으로 이동
        - N번째 칸에 로봇이 있는지 확인 (있으면 로봇 삭제)
    3. 1번 벨트가 내구도 0이상이면 로봇 탑승
    4. 내구도가 0인게 K이상이면 종료
        - 아니라면 1~4 반복
 */

class Main {

    //컨테이너 내구도
    static List<Integer> containerHP = new ArrayList<>();

    //로봇이 탑승했는지 안했는지
    //0 이면 탑승안했음 , 1이면 탑승
    static List<Integer> robot = new ArrayList<>();

    static int count = 0;
    static int result =0;
    public static void main(String[] args) throws Exception {

        int exist = 0;
        int hp = 0;

        //0초
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            containerHP.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            robot.add(0);
        }

        //4. 내구도가 0인게 K이상이면 종료
        while (count < K) {
            result++;

            // 회전 0~ N-1번까지
            Collections.rotate(containerHP, 1);
            Collections.rotate(robot, 1);

            //N-1 번 index가 로봇이 있다면 로봇 삭제
            if (robot.get(N - 1) == 1) {
                robot.remove(N - 1);
                robot.add(N - 1, 0);
            }

            /*
             * 가장 먼저 올라간 로봇부터 1칸씩 회전 (N+1이 내구도 0이상 && 로봇 없어야함)
                - N-2, N-1 … 1 순차적으로 이동
                - N번째 칸에 로봇이 있는지 확인 (있으면 로봇 삭제)
             */
            for (int i = N - 2; i >= 0; i--) {
                // 로봇이 존재하고, 다음칸의 내구도가 0보다 크다면 로봇 이동하고 내구도 1감소
                exist = robot.get(i);
                hp = containerHP.get(i + 1);
                if (exist == 1 && hp > 0 && robot.get(i+1) == 0) {
                    containerHP.remove(i + 1);
                    containerHP.add(i + 1, hp - 1);
                    if(hp-1 == 0) count++;
                    robot.remove(i);
                    robot.add(i, 0);
                    robot.remove(i + 1);
                    robot.add(i + 1, 1);
                }
            }


            if (robot.get(N - 1) == 1) {
                robot.remove(N - 1);
                robot.add(N - 1, 0);
            }

            //0번 index 에 내구도가 0 이상, 로봇이 탑승 안해있으면
            exist = robot.get(0);
            hp = containerHP.get(0);
            if (exist == 0 && hp > 0) {
                robot.remove(0);
                robot.add(0, 1);
                containerHP.remove(0);
                containerHP.add(0, hp - 1);
                if(hp-1 == 0) count++;
            }
        }

        System.out.println(result);
    }



}