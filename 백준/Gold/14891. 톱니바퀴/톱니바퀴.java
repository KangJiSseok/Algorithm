import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{

    static int[][] wheel = new int[4][8];
    static int[] wheelRotate = new int[4];

    public static void main(String[] args) throws Exception {

        int result = 0;

        //=====init=====//
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String wheelText = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = wheelText.charAt(j) - '0';
            }
        }

        int iter = Integer.parseInt(br.readLine());


        for (int i = 0; i < iter; i++) {
            st = new StringTokenizer(br.readLine());
            int wheelNumber = Integer.parseInt(st.nextToken());
            int way = Integer.parseInt(st.nextToken());
            Arrays.fill(wheelRotate, 0);
            wheelRotate[wheelNumber - 1] = 1;
            wheelRotateSearch(wheelNumber - 1);

            leftDfs(wheelNumber - 1, way);

            //wheelNumber - 1 원상복귀
            if (way == -1) {
                rotate(wheelNumber - 1);
            } else if (way == 1) {
                reverseRotate(wheelNumber - 1);
            }

            rightDfs(wheelNumber - 1, way);


//            for (int j = 0; j < 4; j++) {
//                System.out.println();
//                for (int k = 0; k < 8; k++) {
//                    System.out.print(wheel[j][k] + " ");
//                }
//            }

//            System.out.println();
//            for (int j = 0; j < 4; j++) {
//                System.out.print(wheelRotate[j]);
//            }

        }

        if(wheel[0][0] == 1) result += 1;
        if(wheel[1][0] == 1) result += 2;
        if(wheel[2][0] == 1) result += 4;
        if(wheel[3][0] == 1) result += 8;

        System.out.println(result);

    }

    static void leftDfs(int index, int way) {

        if (way == -1) {
            reverseRotate(index);
        } else if (way == 1) {
            rotate(index);
        }

        if(index == 0) return;

        //왼쪽 회전
        if (wheelRotate[index - 1] == 1) {
            way *= -1;
            leftDfs(index - 1, way);
        }
    }

    static void rightDfs(int index, int way) {

        if (way == -1) {
            reverseRotate(index);
        } else if (way == 1) {
            rotate(index);
        }

        if(index == 3) return;

        //오른쪽 회전
        if (wheelRotate[index + 1] == 1) {
            way *= -1;
            rightDfs(index + 1, way);
        }
    }

    //시계방향
    static void rotate(int column){
        int firstValue = wheel[column][7];
        for (int i = wheel[column].length - 2; i >=0 ; i--) {
            wheel[column][i + 1] = wheel[column][i];
        }
        wheel[column][0] = firstValue;

    }

    //반시계방향
    static void reverseRotate(int column){
        int lastValue = wheel[column][0];
        for (int i = 1; i < wheel[column].length; i++) {
            wheel[column][i - 1] = wheel[column][i];
        }
        wheel[column][7] = lastValue;
    }

    //회전시킬 톱니바퀴 확인
    static void wheelRotateSearch(int index) {

        //왼쪽 톱니바퀴
        for (int i = index; i > 0; i--) {
            if (wheel[i - 1][2] == wheel[i][6]) {
                wheelRotate[i - 1] = 0;
                break;
            }else{
                wheelRotate[i - 1] = 1;
            }
        }


        //오른쪽 톱니바퀴
        for (int i = index; i < 3; i++) {
            if (wheel[i][2] == wheel[i+1][6]) {
                wheelRotate[i + 1] = 0;
                break;
            }else {
                wheelRotate[i + 1] = 1;
            }
        }

    }
}