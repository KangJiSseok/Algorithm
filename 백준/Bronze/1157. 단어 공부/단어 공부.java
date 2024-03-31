import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int[] wordList = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                wordList[word.charAt(i) - 'A']++;
            }else{
                wordList[word.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        String result = null;
        for (int i = 0; i < wordList.length; i++) {
            if (wordList[i] > max) {
                max = wordList[i];
                result = String.valueOf((char) (i + 65));
            } else if (wordList[i] == max) {
                result = String.valueOf('?');
            }
        }

        System.out.println(result);



    }
}
