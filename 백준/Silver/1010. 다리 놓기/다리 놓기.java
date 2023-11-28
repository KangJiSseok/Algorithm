import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        int lenT = Integer.parseInt(T);

        int[][] NM = new int[lenT][2];

        double n, r, nr;

        for (int i = 0; i < lenT; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                NM[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // nCr 계산
        for (int i = 0; i < lenT; i++) {

            n = r((NM[i][1])); //맞게 나옴
            r = r(NM[i][0]);
            nr = r(NM[i][1] - NM[i][0]);

            System.out.printf("%.0f",(n / (r * nr)));
            System.out.println();

        }

    }

    private static double r(double i) {
        if( i == 0) return 1;
        if( i== 1) return 1;
        return i * r(i - 1);
    }

}