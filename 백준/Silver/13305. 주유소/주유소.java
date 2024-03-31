import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gasCost = 0;

        //도시 개수
        int nValue = Integer.parseInt(br.readLine());

        int[] cityConnectLine = new int[nValue-1];
        int[] cityGas = new int[nValue];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nValue - 1; i++) {
            cityConnectLine[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nValue; i++) {
            cityGas[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cityGas.length - 1; i++) {
            if (cityGas[i] < cityGas[i + 1]) {
                cityGas[i + 1] = cityGas[i];
            }
        }

        for (int i = 0; i < cityGas.length - 1; i++) {
            gasCost += cityGas[i] * cityConnectLine[i];
        }

        System.out.println(gasCost);
    }
}
