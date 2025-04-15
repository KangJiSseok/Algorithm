import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class 구슬탈출2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static RB initRB;
	static int N, M;
	static char[][] map = new char[11][11];
	static boolean[][][][] visited = new boolean[11][11][11][11];

	//좌 상 우 하
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {

		init();
		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {
		Queue<RB> q = new LinkedList<>();
		q.add(initRB);
		visited[initRB.Ry][initRB.Rx][initRB.By][initRB.Bx] = true;
		while (!q.isEmpty()) {
			RB p = q.poll();
			int ry = p.Ry, rx = p.Rx, by = p.By, bx = p.Bx;
			int count = p.count;
			if(count >= 10) return -1;	//기저 조건
			for (int d = 0; d < 4; d++) {
				//move => 0 : 이동한 y 위치, 1 : 이동한 x 위치, 2 : 이동한 횟수
				int[] Rmove = move(ry, rx, d);
				int[] Bmove = move(by, bx, d);
				/**
				 * com[4] == 0인경우 b가 먼저 0에 도착했으므로 큐에 넣지 않음.
				 * com[4] == 1인경우 a가 먼저 0에 도착했으므로 결과 도출
				 * com[4] == 2인경우 a,b 모두 0를 지나치지 않음.
				 */
				int[] com = compare(Rmove, Bmove, d);
				if(com[4] == 0) continue;
				else if(com[4] == 1) return count + 1;	//기저 조건
				else if(com[4] == 2) {
					int nry = com[0], nrx = com[1], nby = com[2], nbx = com[3];
					if(!visited[nry][nrx][nby][nbx]){
						q.add(new RB(nry, nrx, nby, nbx, count + 1));
						visited[nry][nrx][nby][nbx] = true;
					}
				}
			}
		}
		return -1;
	}

	public static int[] compare(int[] r, int[] b, int d) {
		int ry = r[0], rx = r[1], rc = r[2], rHole = r[3];
		int by = b[0], bx = b[1], bc = b[2], bHole = b[3];

		//r만 0을 지나쳤을떄
		if (rHole == 1 && bHole == 0) {
			return new int[] {0, 0, 0, 0, 1};
		}
		//b만 0을 지나쳤을때
		else if (rHole == 0 && bHole == 1) {
			return new int[] {0, 0, 0, 0, 0};
		}
		//r, b 모두 0을 지나쳤을때
		else if (rHole == 1 && bHole == 1) {
			return new int[] {0, 0, 0, 0, 0};
		}
		//r, b 모두 0을 지나치지 않았을때
		else{
			if (ry == by && rx == bx) {
				if (rc > bc) {
					ry = ry + dy[(d + 2)%4];
					rx = rx + dx[(d + 2)%4];
				} else if (rc == bc) {
					return null;	//해당 경우의 수 존재 X
				}else{
					by = by + dy[(d + 2)%4];
					bx = bx + dx[(d + 2)%4];
				}
			}
			return new int[] {ry, rx, by, bx, 2};
		}

	}

	public static int[] move(int y, int x, int d) {
		int isHole = 0;
		int count = 0;
		int ny = y, nx = x;

		while(true){
			int a, b;
			a = ny + dy[d];
			b = nx + dx[d];
			if(a < 0 || a >= N || b < 0 || b >= M) break;
			if(map[a][b] == '#') break;
			if(map[a][b] == 'O') isHole = 1;
			ny = a;
			nx = b;
			count++;
		}

		return new int[] {ny, nx, count, isHole};
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int ry = -1, rx = -1, by = -1 , bx = -1;

		for (int i = 0; i < N ; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if(c == 'R'){
					ry = i;
					rx = j;
					map[i][j] = '.';
				} else if (c == 'B') {
					by = i;
					bx = j;
					map[i][j] = '.';
				}else{
					map[i][j] = c;
				}
			}
		}

		initRB = new RB(ry, rx, by, bx,0);
	}

	static class RB{
		int Ry,Rx,By,Bx;
		int count;

		public RB(int ry, int rx, int by, int bx, int count) {
			Ry = ry;
			Rx = rx;
			By = by;
			Bx = bx;
			this.count = count;
		}
	}
}
