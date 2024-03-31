import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Long tip = 0L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] peopleTipList = new Long[N];

        for (int i = 0; i < N; i++) {
            peopleTipList[i] = (long) Integer.parseInt(br.readLine());
        }

        Arrays.sort(peopleTipList);

        for (int i = peopleTipList.length - 1; i >= 0; i--) {
            Long realTip = peopleTipList[i] - ((peopleTipList.length - i) - 1);
            if (realTip >= 0) {
                tip += realTip;
            }
        }

        System.out.println(tip);
    }
}
