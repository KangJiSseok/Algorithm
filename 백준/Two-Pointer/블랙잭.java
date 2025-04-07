import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙잭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		int answer = 0;
		int left, right, sum;
		for (int i = 0; i < N - 2; i++) {
			left = i + 1;
			right = N - 1;

			while (left < right) {
				sum = cards[i] + cards[left] + cards[right];

				if (sum == M) {
					System.out.println(sum);
					return;
				}

				if (sum < M) {
					if (sum > answer) {
						answer = sum;
					}
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(answer);
	}
}
