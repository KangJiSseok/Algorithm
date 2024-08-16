import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int[][] array;
    static ArrayList<int[]> homeCoordinate = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[][] chickenCoordinate;
    static int[][] coor;
    static int depth = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homeCoordinate.add(new int[]{i, j});
                } else if (value == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        chickenCoordinate = chicken.stream().toArray(int[][]::new);
        for (int i = 1; i <= M; i++) {
            depth = i;
            coor = new int[i][2];
            dfs(0, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int n, int dep) {
        if (dep == depth) {
            int minSum = calculator();
            result = Math.min(result, minSum);
            return ;
        }

        for (int i = n; i < chicken.size(); i++) {
            int[] ints = chicken.get(i);
            coor[dep][0] = ints[0];
            coor[dep][1] = ints[1];
            dfs(i + 1, dep + 1);
        }


    }

    private static int calculator() {
        int sum = 0;
        for (int[] home : homeCoordinate) {
            int min = Integer.MAX_VALUE;
            for (int[] chicken : coor) {
                int absY = Math.abs(home[0] - chicken[0]);
                int absX = Math.abs(home[1] - chicken[1]);
                min = Math.min(min, absY + absX);
            }
            sum += min;
        }
        return sum;
    }

}