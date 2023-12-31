import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sqrt = 1;
        int count = 0;
        int one = 1;

        for (int i = 1; i <= N; i++) {
            if (i == one) {
                sqrt ++;
                one = sqrt * sqrt;
                count++;
            }
        }
        System.out.println(count);
    }
}


