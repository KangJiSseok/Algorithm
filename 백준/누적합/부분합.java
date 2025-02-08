import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	static int[] arr;
	static int[] pSum;
	static int N, S;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		pSum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sumFuntion();

		int min = Integer.MAX_VALUE;

		int l = 0, r = 1;
		while (l < N) {
			if (prefixSum(l, r)< S) {
				if (r < N) {
					r++;
				}else{
					l++;
				}
			}
			else{
				min = Math.min(min, r - l);
				l++;
			}

		}
		if(min == Integer.MAX_VALUE)
			System.out.println(0);
		else{
			System.out.println(min);
		}
	}

	private static void sumFuntion() {
		for (int i = 1; i <= N; i++) {
			pSum[i] = arr[i] + pSum[i - 1];
		}
	}

	private static int prefixSum(int l, int r) {
		return pSum[r] - pSum[l];
	}
}
