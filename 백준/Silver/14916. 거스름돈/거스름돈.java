import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int fiveDivision = n / 5;
        int fiveRemainder = n % 5;

        if (fiveRemainder == 0) {
            System.out.println(n / 5);
            return;
        }

        int twoDivision;
        while (fiveRemainder <= n) {

            if (fiveRemainder % 2 == 0) {
                twoDivision = fiveRemainder / 2;
                System.out.println(fiveDivision + twoDivision);
                return;
            }

            fiveRemainder = fiveRemainder + 5;
            fiveDivision = fiveDivision - 1;
        }

        System.out.println(-1);
    }
}
