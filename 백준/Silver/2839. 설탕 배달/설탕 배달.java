import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int N = Integer.parseInt(br.readLine()); // 입력

        int fiveCount = 0;

        int NTEMP = N;

        while (NTEMP >= 5) {
            NTEMP = NTEMP - 5;
            fiveCount++;
        }

        int i = 0;
        int fiveValue = N - (fiveCount - i) * 5;
        int fiveRemainder = fiveValue;
        boolean resultBool = false;
        int threeCount = 0;

        while (fiveValue <= N) {
            if (fiveValue % 3 == 0) {
                resultBool = true;
                threeCount = fiveValue / 3;
                break;
            }
            i++;
            fiveCount--;
            fiveValue = i * 5 + fiveRemainder;
        }

        if (resultBool == true) {
            System.out.println(fiveCount + threeCount);
        }else {
            System.out.println(-1);
        }
    }
}