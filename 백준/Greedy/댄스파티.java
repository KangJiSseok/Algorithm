import java.util.*;
import java.io.*;

public class 댄스파티 {
    static ArrayList<Integer> mM = new ArrayList<>();
    static ArrayList<Integer> pM = new ArrayList<>();
    static ArrayList<Integer> mW = new ArrayList<>();
    static ArrayList<Integer> pW = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        //남자
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value < 0) mM.add(value);
            else pM.add(value);
        }

        //여자
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value < 0) mW.add(value);
            else pW.add(value);
        }

        mM.sort((a, b) -> Integer.compare(a, b));
        pM.sort((a, b) -> Integer.compare(b, a));
        mW.sort((a, b) -> Integer.compare(a, b));
        pW.sort((a, b) -> Integer.compare(b, a));

        int left;
        int right;
        int count = 0;

        left = 0;
        right = pW.size() - 1;

        for (Integer m : mM) {
            while (left <= right) {
                if (Math.abs(m) > pW.get(left)) {
                    count++;
                    left++;
                    break;
                } else if (Math.abs(m) == pW.get(left)) {
                    left++;
                }else{
                    left++;
                }
            }
        }

        left = 0;
        right = pM.size() - 1;

        for (Integer w : mW) {
            while (left <= right) {
                if (Math.abs(w) > pM.get(left)) {
                    count++;
                    left++;
                    break;
                } else if (Math.abs(w) == pM.get(left)) {
                    left++;
                }else{
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}

