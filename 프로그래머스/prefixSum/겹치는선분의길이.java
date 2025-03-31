import java.util.*;

public class Solution {
	public int solution(int[][] lines) {
		List<int[]> list = new ArrayList<>();

		for (int[] line : lines) {
			list.add(new int[]{line[0], 1});
			list.add(new int[]{line[1], -1});
		}

		list.sort((a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		int answer = 0;
		int prefixSum = 0;
		int prev = list.get(0)[0];

		for (int i = 0; i < list.size(); i++) {
			int curCoord = list.get(i)[0];
			int value = list.get(i)[1];
			
			if (prefixSum >= 2) {
				answer += curCoord - prev;
			}

			prefixSum += value;
			prev = curCoord;
		}

		return answer;
	}
}
