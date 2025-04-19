import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			map.put(value, map.getOrDefault(value, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());

			if(map.containsKey(value)){
				sb.append(map.get(value)).append(" ");
			}else{
				sb.append("0 ");
			}
		}

		System.out.println(sb);
	}
}
