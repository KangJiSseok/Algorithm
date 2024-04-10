import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] mainArray;
    static int[] searchArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        mainArray = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int main = Integer.parseInt(st.nextToken());
            mainArray[i] = main;
        }

        int M = Integer.parseInt(br.readLine());
        searchArray = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            searchArray[i] = search;
        }

        //binarySearch 하기 위한 mainArray 정렬
        Arrays.sort(mainArray);

        for (int i = 0; i < M; i++) {
            binarySearch(0, N - 1, searchArray[i]);
        }


    }

    private static void binarySearch(int low, int high, int target) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (mainArray[mid] == target) {
                System.out.println(1);
                return;
            } else if (mainArray[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(0);
    }

}