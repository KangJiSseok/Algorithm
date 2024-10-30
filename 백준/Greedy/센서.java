import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class 센서 {

    static int[] sensor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        sensor = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        ArrayList<Integer> distance = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            distance.add(sensor[i + 1] - sensor[i]);
        }

        distance.sort(Collections.reverseOrder());
        int result = sensor[sensor.length - 1] - sensor[0];

        int i = 0;
        for (Integer value : distance) {
            if(i == K - 1) break;
            result -= value;
            i++;
        }

        System.out.println(result);

    }
}


/**
 *
 *  1   2   3   4   5   6   7   8   9
 *  o       o           o   o       o
 *  |                   |
 */
