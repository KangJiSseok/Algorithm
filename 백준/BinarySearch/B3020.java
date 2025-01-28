import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3020 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] even = new int[N/2];
		int[] odd = new int[N/2];

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				even[i/2] = Integer.parseInt(br.readLine());
			}else{
				odd[i/2] = Integer.parseInt(br.readLine());
			}
		}

		Arrays.sort(even);
		Arrays.sort(odd);

		int min = Integer.MAX_VALUE;
		int minCount = 0;
		for (int i = 1; i <= H; i++) {
			int evenDestory = binarySearch(even, i);
			int oddDestory = binarySearch(odd, H - i + 1);
			if (evenDestory + oddDestory < min) {
				min = evenDestory + oddDestory;
				minCount = 1;
			} else if (evenDestory + oddDestory == min) {
				minCount++;
			}else{
				continue;
			}
		}

		System.out.println(min + " " + minCount);

	}
	public static int binarySearch(int[] arr, int tar) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] < tar) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return arr.length - left;
	}
}
