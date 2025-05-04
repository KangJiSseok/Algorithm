import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1253 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] num;
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		init();
		int result = 0;

		for (int i = 0; i < N; i++) {
			map.put(num[i], map.get(num[i]) - 1);
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				int target = num[i] - num[j];
				map.put(num[j], map.get(num[j]) - 1);

				if(map.containsKey(target) && map.get(target) > 0) {
					result += 1;
					map.put(num[j], map.get(num[j]) + 1);
					break;
				}
				map.put(num[j], map.get(num[j]) + 1);

			}
			map.put(num[i], map.get(num[i]) + 1);
		}

		System.out.println(result);
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			map.put(num[i],map.getOrDefault(num[i], 0) + 1);
		}
	}
}
