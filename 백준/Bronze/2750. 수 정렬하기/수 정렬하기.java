import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (value[j] > value[j + 1]) {
                    temp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }
}

