import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int[] value = new int[5];

        for (int i = 0; i < 5; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;

        for (int i = 0; i < 5 - 1; i++) {
            for (int j = 0; j < 5 - 1; j++) {
                if (value[j] > value[j + 1]) {
                    temp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = temp;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
        }

        System.out.println(sum / 5);
        System.out.println(value[2]);
    }
}

