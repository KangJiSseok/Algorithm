import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while (true) {
            if (T.length() == 0) {
                System.out.println(0);
                return;
            }
            if (S.equals(T)) {
                System.out.println(1);
                return;
            }

            /**
             * 우선순위
             * 1. 마지막이 A면 삭제
             * 2  첫번째 문자가 A이면 마지막 문자 B삭제 후 뒤집기
             * 3. 첫번쨰 마지막 문자 둘 다 B인 경우
             */
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else if (T.charAt(0) == 'A') {
                T = T.substring(0, T.length() - 1);
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            } else if (T.charAt(0) == 'B' && T.charAt(T.length() - 1) == 'B') {
                T = T.substring(0, T.length() - 1);
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }
    }
}
