import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int index = 0;
        for (int i = 1; i <= 9; i++) {
            int value = Integer.parseInt(br.readLine());
            if (max < value) {
                max = value;
                index = i;
            }
        }
        System.out.println(max + "\n" + index);
    }
}

