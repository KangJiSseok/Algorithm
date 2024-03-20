import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        String s = br.readLine();
        int N = Integer.parseInt(s.substring(0, s.length() - 2) + "00");
        int F = Integer.parseInt(br.readLine());
        while (true) {
            int a = N % F;
            if (a == 0) {
                String resultString = Integer.toString(N);
                System.out.println(resultString.substring(resultString.length() - 2));
                break;
            }
            N++;
        }

    }
}