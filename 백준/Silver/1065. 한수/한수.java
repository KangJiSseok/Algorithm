import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i = 0, j = 0;
        int count = 1;
        int hansu = 0;


        int[] calArray = new int[4];

        int N = scanner.nextInt();

        int temp = N;

        int[] array = new int[N + 1];

        // N의 자리수
        if (temp < 10) {
            count = 1;
        }
        while (true) {
            if (temp >= 10) {
                temp = temp / 10;
                count++;
            } else {
                break;
            }
        }

        int[] eachArray = new int[count + 1];


        // 각 배열에 N개의 숫자를 넣기
        for (i = 1; i < N + 1; i++) {
            array[i] = i;   //array[] = {1,2,3,4,5 ....}
            eachArray[count] = array[i] % (int) Math.pow(10, count);
            if (i < 10) {
                hansu++;
            } else if (i >= 10 && i < 100) {
                hansu++;
            } else {
                calArray[1] = array[i] / 100;
                array[i] %= 100;
                calArray[2] = array[i] / 10;
                array[i] %= 10;
                calArray[3] = array[i];
                if (calArray[1] == calArray[2] && calArray[2] == calArray[3]) {
                    hansu++;
                }
                for (int k = 1; k < 5; k++) {
                    if (calArray[1] == calArray[2] + k && calArray[2] == calArray[3] + k) {
                        hansu++;
                    }
                    else if (calArray[1] == calArray[2] -k && calArray[2] == calArray[3] -k) {
                        hansu++;
                    }
                }

            }
        }

        System.out.println(hansu);

    }
}