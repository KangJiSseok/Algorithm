import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 합 {

    static Long[] alpha = new Long[10];
    static boolean[] isFirstAlpha = new boolean[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(alpha, 0L);

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String text = br.readLine();
            words[i] = text;
            int length = text.length();
            long sum = 1;
            for (int j = length - 1; j >= 0; j--) {
                alpha[text.charAt(j) - 'A'] += sum;
                sum *= 10;
            }
            isFirstAlpha[text.charAt(0) - 'A'] = true;
        }

        Integer[] indexAlpha = new Integer[10];
        for (int i = 0; i < 10; i++) {
            indexAlpha[i] = i;
        }

        Arrays.sort(indexAlpha, (a, b) -> Long.compare(alpha[b], alpha[a]));


        int notFirst = -1;

        for (int i = 9; i >= 0; i--) {
            if(!isFirstAlpha[indexAlpha[i]]) {
                notFirst = indexAlpha[i];
                break;
            }
        }

        int[] resultArray = new int[10];
        int value = 9;
        for (int i = 0; i < 10; i++) {
            if (indexAlpha[i] == notFirst) {
                resultArray[indexAlpha[i]] = 0;
            } else {
                resultArray[indexAlpha[i]] = value--;
            }
        }


        long result = 0;
        for (String word : words) {
            long sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum = sum * 10 + resultArray[word.charAt(i) - 'A'];
            }
            result += sum;
        }

        System.out.println(result);


    }
}

/**
 * A   B   C   D   E   F   G    H   I   J
 * 4  100  50  2   1  99  1000  10  5   6
 * 2   8   6   1   0  7    9    5   3   4
 * 1   1   1   1   1  1    1    1   0   1
 * -> G : 9 ... J 까지 하고, I = 0이 되어도 되니까,
 * G B F C H J I A D E
 * 9 8 7 6 5 4 0 3 2 1 이 되면 된다.
 *
 * 나온 알파벳이 10개이면 하나는 0이여야함.
 *
 */