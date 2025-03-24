import java.util.Arrays;
import java.util.PriorityQueue;

public class L3169 {
	class Node{
		int day;
		int se;
		Node(int day, int se){
			this.day = day;
			this.se = se;
		}
	}

	public int countDays(int days, int[][] meetings) {
		int result = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
			return Integer.compare(o1.day, o2.day);
		});

		for(int i=0; i< meetings.length; i++){
			pq.add(new Node(meetings[i][0], 1));
			pq.add(new Node(meetings[i][1] + 1, -1));
		}

		int size = pq.size();
		int prefix = 0;
		int preTime = 1;
		while(!pq.isEmpty()){
			Node n = pq.poll();
			if(prefix == 0 && n.day > preTime){
				result += n.day - preTime;
			}
			prefix += n.se;
			preTime = n.day;

		}

		if(preTime <= days && prefix == 0){
			result += days - preTime + 1;
		}

		return result;
	}
}
