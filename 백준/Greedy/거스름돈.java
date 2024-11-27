import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int price = Integer.parseInt(br.readLine());
        int division = 1000 - price;
        int result = 0;
        result += division / 500;
        division %= 500;
        result += division / 100;
        division %= 100;
        result += division / 50;
        division %= 50;
        result += division / 10;
        division %= 10;
        result += division / 5;
        division %= 5;
        result += division / 1;
        System.out.println(result);

    }
}
