import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        if (a == 0) {
            x = (f - (c * e) / b) / d;
            y = c / b;
        }


        y = (f * a - c * d) / (a * e - b * d);
        x = (f * b - c * e) / (b * d - a * e);



        sb.append(x).append(" ");
        sb.append(y);
        System.out.println(sb);
    }
}