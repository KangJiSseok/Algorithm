import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 중앙값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;

	static TreeMap<Integer, Integer> ltm = new TreeMap<>();
	static TreeMap<Integer, Integer> rtm = new TreeMap<>();
	static int ls = 0, rs = 0;
	static long result = 0L;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			int key = arr[i];
			addKey(key);
			if(ls + rs == K){
				rebalance();
				result += ltm.lastKey();
				removeKey(arr[i - K + 1]);
			}
		}

		System.out.println(result);
	}

	private static void addKey(Integer addKey) {
		if(ltm.isEmpty()){
			ls++;
			ltm.put(addKey, ltm.getOrDefault(addKey, 0) + 1);
			return;
		}

		if(addKey > ltm.lastKey()){
			rs++;
			rtm.put(addKey, rtm.getOrDefault(addKey, 0) + 1);
		}else{
			ls++;
			ltm.put(addKey, ltm.getOrDefault(addKey, 0) + 1);
		}
	}

	private static void removeKey(Integer removeKey) {
		if(ltm.containsKey(removeKey)){
			if(ltm.get(removeKey) - 1 == 0){
				ltm.remove(removeKey);
			}else{
				ltm.put(removeKey, ltm.get(removeKey) - 1);
			}
			ls--;
		}else{
			if(rtm.get(removeKey) - 1 == 0){
				rtm.remove(removeKey);
			}else{
				rtm.put(removeKey, rtm.get(removeKey) - 1);
			}
			rs--;
		}
		rebalance();
	}

	static void rebalance() {
		while (ls > rs + 1) {
			ls--;
			rs++;
			Integer key = ltm.lastKey();
			if (ltm.get(key) - 1 == 0) {
				ltm.pollLastEntry();
			} else {
				ltm.put(key, ltm.get(key) - 1);
			}
			rtm.put(key, rtm.getOrDefault(key, 0) + 1);
		}

		while(rs >= ls + 1){
			ls++;
			rs--;
			Integer key = rtm.firstKey();
			if (rtm.get(key) - 1 == 0) {
				rtm.pollFirstEntry();
			} else {
				rtm.put(key, rtm.get(key) - 1);
			}
			ltm.put(key, ltm.getOrDefault(key, 0) + 1);
		}
	}
}
