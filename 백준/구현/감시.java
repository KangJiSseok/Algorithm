import java.util.*;
import java.io.*;

public class 감시 {
	static List<CCTV> cctvList = new ArrayList<>();
	static int[][] map, copyMap;
	static int size, N, M;
	static int min = Integer.MAX_VALUE;

	// 우, 하, 좌, 상
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				int value = Integer.parseInt(st.nextToken());
				if(value != 0 && value != 6) {
					cctvList.add(new CCTV(value, i, j));
				}
				map[i][j] = value;
			}
		}
		size = cctvList.size();
		int[] directions = new int[size];
		dfs(0, directions);
		System.out.println(min);
	}

	// idx번째 CCTV에 대해 가능한 방향 조합만 고려
	private static void dfs(int idx, int[] directions) {
		if(idx == size) {
			copyMap = new int[N][M];
			for(int i = 0; i < N; i++){
				copyMap[i] = map[i].clone();
			}
			for(int i = 0; i < size; i++){
				cover(cctvList.get(i), directions[i]);
			}
			min = Math.min(min, countBlind());
			return;
		}

		int type = cctvList.get(idx).num;
		int rotationCount = 0;
		if(type == 1 || type == 3 || type == 4) rotationCount = 4;
		else if(type == 2) rotationCount = 2;
		else if(type == 5) rotationCount = 1;

		for (int i = 0; i < rotationCount; i++){
			directions[idx] = i;
			dfs(idx + 1, directions);
		}
	}

	// 사각 지대(0)의 개수를 센다.
	private static int countBlind() {
		int count = 0;
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				if(copyMap[i][j] == 0) count++;
			}
		}
		return count;
	}

	// CCTV 종류 및 회전에 따라 감시 방향을 확장한다.
	private static void cover(CCTV cctv, int rotation) {
		int type = cctv.num;
		switch(type) {
			case 1:
				simulate(cctv, rotation);
				break;
			case 2:
				if(rotation == 0) {
					simulate(cctv, 0);
					simulate(cctv, 2);
				} else {
					simulate(cctv, 1);
					simulate(cctv, 3);
				}
				break;
			case 3:
				if(rotation == 0) {
					simulate(cctv, 0);
					simulate(cctv, 1);
				} else if(rotation == 1) {
					simulate(cctv, 1);
					simulate(cctv, 2);
				} else if(rotation == 2) {
					simulate(cctv, 2);
					simulate(cctv, 3);
				} else if(rotation == 3) {
					simulate(cctv, 3);
					simulate(cctv, 0);
				}
				break;
			case 4:
				if(rotation == 0) {
					simulate(cctv, 0);
					simulate(cctv, 1);
					simulate(cctv, 2);
				} else if(rotation == 1) {
					simulate(cctv, 1);
					simulate(cctv, 2);
					simulate(cctv, 3);
				} else if(rotation == 2) {
					simulate(cctv, 2);
					simulate(cctv, 3);
					simulate(cctv, 0);
				} else if(rotation == 3) {
					simulate(cctv, 3);
					simulate(cctv, 0);
					simulate(cctv, 1);
				}
				break;
			case 5:
				simulate(cctv, 0);
				simulate(cctv, 1);
				simulate(cctv, 2);
				simulate(cctv, 3);
				break;
		}
	}

	// 단순 while 루프로 한 방향으로 벽 또는 범위 종료 전까지 감시 영역 표시
	private static void simulate(CCTV cctv, int d) {
		int ny = cctv.y;
		int nx = cctv.x;
		while(true) {
			ny += dy[d];
			nx += dx[d];
			if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyMap[ny][nx] == 6) break;
			if(copyMap[ny][nx] == 0) {
				copyMap[ny][nx] = -1;
			}
		}
	}
}

class CCTV {
	int num, y, x;
	public CCTV(int num, int y, int x) {
		this.num = num;
		this.y = y;
		this.x = x;
	}
}
