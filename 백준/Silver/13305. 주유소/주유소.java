import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long gasCost = 0;

        //도시 개수
        int nValue = Integer.parseInt(br.readLine());

        long[] cityConnectLine = new long[nValue - 1];
        long[] cityGas = new long[nValue];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < nValue - 1; i++) {
            cityConnectLine[i] = Integer.parseInt(st.nextToken());
            cityGas[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < cityGas.length - 1; i++) {
            if (cityGas[i] < cityGas[i + 1]) {
                cityGas[i + 1] = cityGas[i];
            }

            gasCost += cityGas[i] * cityConnectLine[i];
        }

        System.out.println(gasCost);
        br.close();
    }
}
