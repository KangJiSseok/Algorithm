import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] tmp = new int[1000001];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        sort(list, 0, N - 1);
        
        for (int i = 0; i < N; i++) {
            sb.append(list[i]).append("\n");
        }

        System.out.println(sb.toString());

    }


    private static void sort(int[] list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //왼쪽 분할
            sort(list, left, mid);
            //오른쪽 분할
            sort(list, mid + 1, right);
            //합치기
            merge(list, left, mid, right);

        }
    }

    private static void merge(int[] list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int t = left;

        while (i <= mid && j <= right) {
            if (list[i] < list[j]) {
                tmp[t++] = list[i++];
            }else{
                tmp[t++] = list[j++];
            }
        }
        
        while (i <= mid) {
            tmp[t++] = list[i++];
        }

        while (j <= right) {
            tmp[t++] = list[j++];
        }
        
        for (int k = left; k <= right; k++) {
            list[k] = tmp[k];
        }
    }

}
