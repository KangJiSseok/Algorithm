import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static String result ="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            result++;
        }
        System.out.println(result);
    }
}