import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int result;
    static boolean a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);

        for (int i = 0; i < N; i++) {

            if (i >= 10) {
                result = 0;
                String I = Integer.toString(i);
                for (int j = 0; j < I.length(); j++) {
                    result += Integer.parseInt(String.valueOf(I.charAt(j)));
                }
                result += Integer.parseInt(I);
            }else {
                if ((i + i) == N) {
                    System.out.println(i);
                    a = true;
                    break;
                }
            }

            if (result == N) {
                System.out.println(i);
                a = true;
                break;
            }
        }

        if (!a) {
            System.out.println("0");
        }
    }
}