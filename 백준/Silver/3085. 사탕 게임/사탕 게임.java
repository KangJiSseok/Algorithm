import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static String[][] candy;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        candy = new String[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j);
                row(N);
                column(N);
                swap(i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap1(i, j);
                row(N);
                column(N);
                swap1(i, j);
            }
        }


        System.out.println(max);

    }

    private static void row(int N) {
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candy[i][j].equals(candy[i][j + 1])) {
                    count++;
                    max = Math.max(count, max);
                } else count = 1;
            }
        }
    }

    private static void column(int N) {
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candy[j][i].equals(candy[j + 1][i])) {
                    count++;
                    max = Math.max(count, max);
                } else count = 1;
            }
        }
    }

    private static void swap(int i, int j) {
        String temp;
        temp = candy[i][j + 1];
        candy[i][j + 1] = candy[i][j];
        candy[i][j] = temp;
    }

    private static void swap1(int i, int j) {
        String temp;
        temp = candy[i + 1][j];
        candy[i + 1][j] = candy[i][j];
        candy[i][j] = temp;
    }
}

