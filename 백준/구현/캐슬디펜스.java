import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class 캐슬디펜스 {
	static int N, M, D, max;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					max = Math.max(max,game(new int[] {i, j, k}));
				}
			}
		}

		System.out.println(max);
	}

	private static int game(int[] ranger) {
		int count = 0;
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = board[i].clone();
		}

		for (int d = 0; d < N; d++) {
			//중복 처리 해야함
			List<Remove> removeList = attack(ranger, copy);
			HashSet<Remove> removeSet = new HashSet<>(removeList);
			count += removeSet.size();	// 없애는 상대 숫자
			for (Remove remove : removeSet) {
				copy[remove.y][remove.x] = 0;
			}
			downCastle(copy);
		}

		return count;
	}

	private static void downCastle(int[][] copy) {
		for (int i = N - 1; i > 0; i--) {
			copy[i] = copy[i - 1].clone();
		}
		Arrays.fill(copy[0], 0);
	}

	private static List<Remove> attack(int[] ranger, int[][] copyBoard) {

		List<Remove> removeList = new ArrayList<>();

		for (int personX : ranger) {
			PriorityQueue<Castle> pq = new PriorityQueue<>((o1, o2) -> {
				if (o1.distance == o2.distance) {
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o1.distance, o2.distance);
			});


			//1명의 아처가 벽 부술거 pq에 넣기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copyBoard[i][j] == 1){
						int dis = calDistance(N, personX, i, j);
						if(dis <= D) pq.add(new Castle(dis, i, j));
					}
				}
			}

			// 잡을 적이 없으면 패스
			if(pq.isEmpty()) continue;

			Castle poll = pq.poll();
			removeList.add(new Remove(poll.y, poll.x));
		}

		return removeList;
	}

	private static int calDistance(int y, int x, int tY, int tX) {
		return Math.abs(tY - y) + Math.abs(tX - x);
	}
}


class Castle{
	int distance;
	int y;
	int x;

	public Castle(int distance, int y, int x) {
		this.distance = distance;
		this.y = y;
		this.x = x;
	}
}

class Remove{
	int y;
	int x;

	public Remove(int y, int x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Remove remove = (Remove)o;
		return y == remove.y && x == remove.x;
	}

	@Override
	public int hashCode() {
		return Objects.hash(y, x);
	}
}