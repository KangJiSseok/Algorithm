import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[] aPeople;
    static int[] bPeople;
    static int[] cPeople;
    static int[] result = new int[101];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        aPeople = extracted(br);
        bPeople = extracted(br);
        cPeople = extracted(br);

        for (int i = 1; i < 101; i++) {
            result[i] = aPeople[i] + bPeople[i] + cPeople[i];

            if (result[i] == 0) {
                continue;
            } else if (result[i] == 1) {
                sum += A*result[i];
            } else if (result[i] == 2) {
                sum += B*result[i];
            } else if (result[i] == 3) {
                sum += C*result[i];
            }
        }
        System.out.println(sum);

    }

    private static int[] extracted(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] people = new int[101];
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = start; i < end; i++) {
            people[i] = 1;
        }
        return people;
    }
}