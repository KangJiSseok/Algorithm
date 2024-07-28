import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int[] lis;
    static int N;

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = array[0];
        int lisLength = 1;

        for (int i = 1; i < N; i++) {
            int key = array[i];

            if (lis[lisLength - 1] < key) {
                lisLength++;
                lis[lisLength - 1] = key;
            } else {
                int lowSearchIndex = lowSearch(0, lisLength, key);
                lis[lowSearchIndex] = key;
            }
        }

        System.out.println(lisLength);

    }

    static int lowSearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}