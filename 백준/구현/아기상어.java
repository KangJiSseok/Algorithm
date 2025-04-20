import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class 아기상어 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int[][] map;

	//상 좌 하 우
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int N;
	static Shack shack = null;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		init();
		game();
		System.out.println(shack.time);
	}

	private static void game() {

		while(true){
			boolean bfs = bfs();
			if(!bfs) return;
		}
	}

	private static boolean bfs() {
		PriorityQueue<Fish> pq = new PriorityQueue<>(((o1, o2) -> {
			if(o1.time == o2.time){
				if(o1.y == o2.y){
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o1.y, o2.y);
			}
			return Integer.compare(o1.time, o2.time);
		}));

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {shack.y, shack.x, 0});
		visited[shack.y][shack.x] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p[0] + dy[i];
				int nx = p[1] + dx[i];
				if(ny < 0 || ny >=N || nx < 0 || nx >=N || visited[ny][nx]) continue;

				if(map[ny][nx] == shack.level || map[ny][nx] == 0){
					q.add(new int[]{ny,nx, p[2] + 1});
					visited[ny][nx] = true;
				}
				else if(map[ny][nx] < shack.level){
					pq.add(new Fish(ny, nx, p[2] + 1));
					q.add(new int[]{ny,nx, p[2] + 1});
					visited[ny][nx] = true;
				}
			}
		}

		if(!pq.isEmpty()){
			Fish fish = pq.poll();
			shack.addTime(fish.time);
			shack.addEXP();
			shack.pointCoordination(fish.y, fish.x);
			map[fish.y][fish.x] = 0;
			// System.out.println("ny = " + fish.y + " nx = " + fish.x + " time = " + shack.time + " level = " + shack.level + " count = " + count);
			return true;
		}
		return false;
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == 9){
					shack = new Shack(i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	static class Shack{
		int y, x;
		int level = 2;
		int exp = 0;
		int time = 0;

		public Shack(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public void addEXP() {
			exp++;
			if(exp == level){
				level++;
				exp = 0;
			}
		}

		public void addTime(int addTime) {
			time += addTime;
		}

		public void pointCoordination(int ny, int nx) {
			this.y = ny;
			this.x = nx;
		}
	}

	static class Fish{
		int y, x, time;

		public Fish(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
}