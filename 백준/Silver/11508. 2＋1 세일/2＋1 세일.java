import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int result = 0;

        int N = Integer.parseInt((br.readLine()));
        Integer[] KSGArray = new Integer[N + 1];
        KSGArray[0] = 0;

        for (int i = 1; i <= N; i++) {
            KSGArray[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(KSGArray, Collections.reverseOrder());
//        System.out.println("Arrays.toString(KSGArray) = " + Arrays.toString(KSGArray));

        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 == 0) {
                continue;
            } else {
                result += KSGArray[i];
            }
        }

        System.out.println(result);
    }
}