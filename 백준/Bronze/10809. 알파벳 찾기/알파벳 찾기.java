import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] result = new int[26];
        Arrays.fill(result, -1);
        HashSet<Integer> set = new HashSet<>();

        String text = br.readLine();

        for (int i = 0; i < text.length(); i++) {
            int value = text.charAt(i) - 'a';

            if (set.contains(value)) {
                continue;
            }else{
                set.add(value);
                result[value] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb.toString());

    }
}



