import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2780 {
	public int minimumIndex(List<Integer> nums) {
		int n = nums.size();

		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		int dominant = -1;
		int totalCount = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > n / 2) {
				dominant = entry.getKey();
				totalCount = entry.getValue();
				break;
			}
		}

		int leftCount = 0;
		for (int i = 0; i < n - 1; i++) {
			if (nums.get(i) == dominant) {
				leftCount++;
			}

			int leftLen = i + 1;
			int rightLen = n - leftLen;

			if (leftCount > leftLen / 2 && (totalCount - leftCount) > rightLen / 2) {
				return i;
			}
		}

		return -1;
	}
}
