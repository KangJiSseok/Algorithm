import java.util.ArrayList;
import java.util.List;

public class L3394 {
	class Node {
		long start, end;
		Node(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}

	private List<Node> merge(List<Node> list) {
		if(list.isEmpty()) return list;
		list.sort((o1, o2) -> Long.compare(o1.start, o2.start));
		List<Node> mergeList = new ArrayList<>();
		Node cur = list.get(0);
		for(int i = 1; i < list.size(); i++){
			Node next = list.get(i);
			if(next.start <= cur.end){
				cur.end = Math.max(cur.end, next.end);
			} else {
				mergeList.add(cur);
				cur = next;
			}
		}
		mergeList.add(cur);
		return mergeList;
	}

	public boolean checkValidCuts(int n, int[][] rectangles) {
		List<Node> xList = new ArrayList<>();
		List<Node> yList = new ArrayList<>();

		for (int i = 0; i < rectangles.length; i++){
			long x1 = rectangles[i][0];
			long y1 = rectangles[i][1];
			long x2 = rectangles[i][2];
			long y2 = rectangles[i][3];
			xList.add(new Node(3 * x1, 3 * x2 - 2));
			yList.add(new Node(3 * y1, 3 * y2 - 2));
		}

		List<Node> xMergeList = merge(xList);
		List<Node> yMergeList = merge(yList);

		int kx = xMergeList.size();
		int ky = yMergeList.size();

		return (kx >= 3 || ky >= 3);
	}
}
