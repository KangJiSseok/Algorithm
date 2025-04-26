import java.io.*;
import java.util.*;

public class 집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		HashSet<Integer> hashSet = new HashSet<>();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			if (order.equals("add")) {
				Integer key = Integer.parseInt(st.nextToken());
				hashSet.add(key);

			} else if (order.equals("remove")) {
				Integer key = Integer.parseInt(st.nextToken());
				if(hashSet.contains(key)) hashSet.remove(key);

			} else if (order.equals("check")) {
				Integer key = Integer.parseInt(st.nextToken());
				if(hashSet.contains(key)) sb.append("1").append("\n");
				else sb.append("0").append("\n");

			} else if (order.equals("toggle")) {
				Integer key = Integer.parseInt(st.nextToken());
				if(hashSet.contains(key)) hashSet.remove(key);
				else hashSet.add(key);

			} else if (order.equals("all")) {
				hashSet = new HashSet<>();
				for (int i = 1; i <= 20; i++) {
					hashSet.add(i);
				}
			}else{
				hashSet = new HashSet<>();
			}
		}

		System.out.println(sb);
	}
}
