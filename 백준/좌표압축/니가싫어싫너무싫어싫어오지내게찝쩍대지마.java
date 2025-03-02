import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 니가싫어싫너무싫어싫어오지내게찝쩍대지마 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		int[][] arr = new int[N * 2][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			arr[i * 2] = new int[] {S, 1};
			arr[i * 2 + 1] = new int[] {E, -1};
		}

		Arrays.sort(arr, ((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		}));

		int sum = 0;
		int max = 0;
		int ans_start = 0, ans_end = 0;

		boolean opened = false;

		int i = 0;
		while(i < 2 * N) {
			int cur_time = arr[i][0];

			while(i < 2 * N && arr[i][0] == cur_time) {
				sum += arr[i][1];
				i++;
			}

			if(sum > max) {
				max = sum;
				ans_start = cur_time;
				opened = true;
			} else if(sum < max && opened) {
				ans_end = cur_time;
				opened = false;
			}
		}

		System.out.println(max);
		System.out.println(ans_start + " " + ans_end);

	}
}
