import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 합DifferentSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        List<long[]> V = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            V.add(new long[]{0L, i});
        }

        boolean[] isHead = new boolean[10];
        for (String word : A) {
            int len = word.length();
            for (int j = 0; j < len; j++) {
                V.get(word.charAt(j) - 'A')[0] += (long)Math.pow(10, len - 1 - j);
                if (j == 0) {
                    isHead[word.charAt(j) - 'A'] = true;
                }
            }
        }

        Collections.sort(V, ((o1, o2) -> {
            if(o1[0] - o2[0] > 0) return 1;
            return -1;
        }));

//        for (long[] longs : V) {
//            System.out.println(longs[0] + " " + longs[1]);
//        }

        if (isHead[(int)V.get(0)[1]]) {
            int i = 1;
            while (isHead[(int)V.get(i)[1]]) {
                i++;
            }
            for (int j = i; j > 0; j--) {
                Collections.swap(V, j, j - 1);
            }
        }

//        System.out.println("=========");
//
//        for (long[] longs : V) {
//            System.out.println(longs[0] + " " + longs[1]);
//        }


        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += i * V.get(i)[0];
        }

        System.out.println(ans);
    }
}
