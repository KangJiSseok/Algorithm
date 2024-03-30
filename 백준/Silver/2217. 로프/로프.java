import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] lopeList;
    static int currentValue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        lopeList = new int[N];

        for (int i = 0; i < N; i++) {
            lopeList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lopeList);

        for (int i = lopeList.length - 1; i >= 0; i--) {
            lopeList[i] = lopeList[i] * (lopeList.length - i);
        }

        Arrays.sort(lopeList);

        System.out.println(lopeList[lopeList.length - 1]);
    }
}
