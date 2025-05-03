import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] numList;
	static int[] operator = new int[4];

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		numList = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(numList[0], 0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int operatorSum, int idx) {
		if(idx == N - 1){
			min = Math.min(min, operatorSum);
			max = Math.max(max, operatorSum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				if (i == 0){
					dfs(operatorSum + numList[idx + 1], idx + 1);
				} else if (i == 1) {
					dfs(operatorSum - numList[idx + 1], idx + 1);
				} else if (i == 2) {
					dfs(operatorSum * numList[idx + 1], idx + 1);
				}else{
					dfs(operatorSum / numList[idx + 1], idx + 1);
				}

				operator[i]++;
			}
		}
	}
}
