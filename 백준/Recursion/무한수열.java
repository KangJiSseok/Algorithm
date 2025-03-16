import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 무한수열 {
	static long N, P, Q;
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.valueOf(st.nextToken());
		P = Long.valueOf(st.nextToken());
		Q = Long.valueOf(st.nextToken());


		System.out.println(dfs(N));
	}

	static long dfs(long n) {
		if(n == 0 )return 1;

		long divP = Math.floorDiv(n , P);
		long divQ = Math.floorDiv(n , Q);

		if(map.containsKey(n)) return map.get(n);

		long a = dfs(divP);
		long b = dfs(divQ);
		map.put(n, a + b);
		return map.get(n);
	}
}
