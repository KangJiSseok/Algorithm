import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] coordinateUniverseList;

    static int[][] line;    //[][0] = S, [][1] = E
    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        coordinateUniverseList = new int[N][M];
        for (int i = 0; i < N; i++) {
            int count =0;
            int[] universe = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                universe[j] = Integer.parseInt(st.nextToken());
            }
            int[] temp = universe.clone();
            Arrays.sort(universe);

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < M; j++) {
                if (!map.containsKey(universe[j])) {
                    map.put(universe[j], count++);
                }
            }
            for (int j = 0; j < M; j++) {
                coordinateUniverseList[i][j] = map.get(temp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean same = true;
                for (int k = 0; k < M; k++) {
                    if (coordinateUniverseList[i][k] != coordinateUniverseList[j][k]) {
                        same = false;
                        break;
                    }
                }
                if(same){
                   result++;
                }
            }
        }
        System.out.println(result);

    }
}