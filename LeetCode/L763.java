import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L763 {
	public List<Integer> partitionLabels(String s) {

		List<Integer> result = new LinkedList<>();

		HashMap<Character, Integer> map = new HashMap<>();

		int[] arr = new int[s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			char key = s.charAt(i);
			if(map.containsKey(key)){
				arr[i] = map.get(key);
			}else{
				map.put(key, i);
				arr[i] = i;
			}
		}

		int l = -1;
		int maxIndex = -1;
		boolean partition = false;
		for (int r = 0; r < s.length(); r++) {
			if(maxIndex < arr[r]){
				//파티션 시작
				if(!partition) {
					l = r;
					partition = true;
				}
				maxIndex = arr[r];
			}
			//파티션 끝
			if(partition && r == maxIndex){
				result.add(r - l + 1);
				partition = false;
			}
		}

		return result;
	}
}

/**
 a	b	a	b	c	b	a	c	a	d	e	f	e	g	d	e	h	i	j	h	k	l	i	j
 0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23
 8	5	8	5	7	5	8	7	8	14	15	11	15	13	14	15	19	22	23	19	20	21	22	23
 */