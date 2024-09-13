import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        int result = 0;

        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(br.readLine());
            if (set.contains(value % 42)) {
                continue;
            }else{
                set.add(value % 42);
                result++;
            }
        }
        System.out.println(result);

    }
}



