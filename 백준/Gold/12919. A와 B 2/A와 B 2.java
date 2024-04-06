import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String T;
    static String S;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        search(T);
        System.out.println(0);
    }

    static void search(String currentWord) {
        if (currentWord.equals(S)) {
            System.out.println(1);
            System.exit(0);
        }

        if (currentWord.length() == 0) {
            return;
        }

        if (currentWord.charAt(currentWord.length()-1) == 'A') {
            String newWord = currentWord.substring(0, currentWord.length()-1);
            search(newWord);
        }

        if (currentWord.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(currentWord);
            currentWord = sb.reverse().toString();
            String newWord = currentWord.substring(0, currentWord.length() - 1);
            search(newWord);
        }
    }
}
