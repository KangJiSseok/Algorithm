import java.io.*;
import java.util.*;

public class 공주님의정원 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());
		Day[] days = new Day[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			days[i] = new Day(sm * 100 + sd, em * 100 + ed);
		}

		Arrays.sort(days,((o1, o2) -> {
			if (o1.s == o2.s) {
				return Integer.compare(o2.e, o1.e);
			}
			return Integer.compare(o1.s, o2.s);
		}));

		int endDay = 1201;
		int start = 301;
		int count = 0;
		int max = 0;
		int index = 0;

		while (start < endDay) {
			boolean isFinded = false;

			for(int i = index; i < N; i++) {
				if(days[i].s > start) {
					break;
				}

				if(max < days[i].e) {
					isFinded = true;
					max = days[i].e;
					index = i + 1;
				}
			}

			if(isFinded) {
				start = max;
				count++;
			}
			else {
				break;
			}
		}

		if(max < endDay) {
			System.out.println(0);
		}
		else {
			System.out.println(count);
		}
	}


	static class Day {
		int s, e;

		public Day(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

}
