import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 두배열의합 {
	static int[] A,B;
	static int[] aPrefixSum, bPrefixSum;
	static int T,aSize,bSize;
	static HashMap<Long, Long> aMap = new HashMap<>();
	static HashMap<Long, Long> bMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		input();
		prefixSum(A,aPrefixSum);
		prefixSum(B,bPrefixSum);
		mapInput(aPrefixSum, aMap);
		mapInput(bPrefixSum, bMap);
		long result = 0;

		for (Long aSum : aMap.keySet()) {
			long bSum = T - aSum;
			if(bMap.containsKey(bSum)) result += bMap.get(bSum) * aMap.get(aSum);
		}

		System.out.println(result);
		// printPrefixSum(aPrefixSum);
	}

	private static void mapInput(int[] prefixSum, HashMap<Long,Long> map) {
		for (int i = 1; i < prefixSum.length; i++) {
			for (int j = 1; j <= i; j++) {
				long key = prefixSum[i] - prefixSum[j-1];
				map.put(key, map.getOrDefault(key, 0L) + 1);
			}
		}
	}

	private static void printPrefixSum(int[] prefixSum) {
		System.out.println();
		for (int i = 0; i < prefixSum.length; i++) {
			System.out.print(prefixSum[i] + " ");
		}
	}

	private static void prefixSum(int[] arr, int[] prefixSum) {
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		aSize = Integer.parseInt(br.readLine());
		A = new int[aSize + 1];
		aPrefixSum = new int[aSize + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= aSize; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		bSize = Integer.parseInt(br.readLine());
		B = new int[bSize + 1];
		bPrefixSum = new int[bSize + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= bSize; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}
}
