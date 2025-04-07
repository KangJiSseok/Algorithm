import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상어중학교 {
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	static int N, M;
	static int[][] board;
	static boolean[][] visited;

	static int result = 0;


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true){
			//false = 블록이 2보다 큰거 없다.
			boolean con = searchBigBlock();
			if(!con)break;
			gravity();
			rotate();
			gravity();

			// System.out.println();
			// System.out.println("-----------iter---------------");
			//
			// if(!searchBigBlock()) break;
			// System.out.println("노드 삭제 후");
			// for (int i = 0; i < N; i++) {
			// 	System.out.println();
			// 	for (int j = 0; j < N; j++) {
			// 		System.out.print(board[i][j] + "	");
			// 	}
			// }
			//
			// System.out.println();
			// gravity();
			// System.out.println("중력 작용 후");
			// for (int i = 0; i < N; i++) {
			// 	System.out.println();
			// 	for (int j = 0; j < N; j++) {
			// 		System.out.print(board[i][j] + "	");
			// 	}
			// }
			//
			// System.out.println();
			// rotate();
			// System.out.println("90도 회전 후");
			// for (int i = 0; i < N; i++) {
			// 	System.out.println();
			// 	for (int j = 0; j < N; j++) {
			// 		System.out.print(board[i][j] + "	");
			// 	}
			// }
			//
			// System.out.println();
			// gravity();
			// System.out.println("중력 작용 후");
			// for (int i = 0; i < N; i++) {
			// 	System.out.println();
			// 	for (int j = 0; j < N; j++) {
			// 		System.out.print(board[i][j] + "	");
			// 	}
			// }

		}

		System.out.println(result);


	}

	//90도 회전
	private static void rotate() {
		for (int i = 0; i < N / 2; i++) {
			innerRotate(i, N - i - 1);
		}
	}

	private static void innerRotate(int start, int end) {
		int[] top = new int[N - start * 2];
		int[] left = new int[N - start * 2];
		int[] bottom = new int[N - start * 2];
		int[] right = new int[N - start * 2];

		int size = top.length;

		for (int i = 0; i < size; i++) {
			top[i] = board[start][start + i];
		}
		for (int i = 0; i < size; i++) {
			left[i] = board[end - i][start];
		}
		for (int i = 0; i < size; i++) {
			bottom[i] = board[end][end - i];
		}
		for (int i = 0; i < size; i++) {
			right[i] = board[start + i][end];
		}

		//각 위치에 넣기
		for (int i = 0; i < size; i++) {
			board[start][start + i] = right[i];
		}
		for (int i = 0; i < size; i++) {
			board[start + i][end] = bottom[i];
		}
		for (int i = 0; i < size; i++) {
			board[end][end - i] = left[i];
		}
		for (int i = 0; i < size; i++) {
			board[end - i][start] = top[i];
		}
	}


	//탐색할때 0은 방문처리하면 안됨.
	private static boolean searchBigBlock() {
		visited = new boolean[N][N];

		/**
		 * pq :
		 * 1.크기
		 * 2.무지개블록
		 * 3.행
		 * 4.열
		 */
		PriorityQueue<Block> pq = new PriorityQueue<>(((o1, o2) -> {
			if(o1.size == o2.size){
				if (o1.rainbowSize == o2.rainbowSize) {
					if (o1.standardY == o2.standardY) {
						return Integer.compare(o2.standardX, o1.standardX);
					}
					return Integer.compare(o2.standardY, o1.standardY);
				}
				return Integer.compare(o2.rainbowSize, o1.rainbowSize);
			}
			return Integer.compare(o2.size, o1.size);
		}));


		//모든 블록 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] != 0 && board[i][j] != 6 && board[i][j] != -1) {
					Block block = searchBFS(i, j, board[i][j]);
					if(block == null) continue;
					else pq.add(block);
				}
			}
		}

		//기준이되는 블록주변 모두 삭제
		//없다면 게임 종료
		if(pq.isEmpty()) return false;
		Block removeBlocks = pq.poll();
		int removeY = removeBlocks.standardY;
		int removeX = removeBlocks.standardX;
		removeBFS(removeY, removeX, board[removeY][removeX]);
		return true;
	}


	//삭제된 블록번호 = 6
	private static void removeBFS(int removeY, int removeX, int num) {
		boolean[][] innerVisited = new boolean[N][N];
		Queue<RemoveBlock> q = new LinkedList<>();
		q.add(new RemoveBlock(removeY, removeX));
		board[removeY][removeX] = 6;
		innerVisited[removeY][removeX] = true;
		int removeSize = 1;

		while (!q.isEmpty()) {
			RemoveBlock block = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = block.y + dy[k];
				int nx = block.x + dx[k];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || innerVisited[ny][nx]) continue;
				if(board[ny][nx] == num || board[ny][nx] == 0){
					q.add(new RemoveBlock(ny, nx));
					board[ny][nx] = 6;
					innerVisited[ny][nx] = true;
					removeSize++;
				}
			}
		}
		result += removeSize * removeSize;
	}

	private static Block searchBFS(int i, int j, int num) {
		boolean[][] innerVisited = new boolean[N][N];
		Queue<StandardBlock> q = new LinkedList<>();
		q.add(new StandardBlock(i, j));
		int size = 1, rainbowSize = 0;
		visited[i][j] = true;
		innerVisited[i][j] = true;

		while (!q.isEmpty()) {
			StandardBlock block = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = block.y + dy[k];
				int nx = block.x + dx[k];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || innerVisited[ny][nx]) continue;
				if(board[ny][nx] == num){
					q.add(new StandardBlock(ny, nx));
					size++;
					visited[ny][nx] = true;
					innerVisited[ny][nx] = true;
				}else if(board[ny][nx] == 0){			// 무지개블록은 방문처리하면 안됨.
					q.add(new StandardBlock(ny, nx));
					size++;
					rainbowSize++;
					innerVisited[ny][nx] = true;
				}
			}
		}

		if (size < 2) return null;
		return new Block(size, rainbowSize, i, j);
	}


	// 6 = 삭제한 블록
	private static void gravity() {
		for (int col = 0; col < N; col++) {
			for (int row = N - 2; row >= 0; row--) {
				if(board[row][col] == -1 || board[row][col] == 6) continue;
				int ny = row + 1;
				boolean move = false;
				while (ny < N && board[ny][col] == 6) {
					move = true;
					ny++;
				}
				if(ny <= N && move) {
					board[ny - 1][col] = board[row][col];
					board[row][col] = 6;
				}
			}
		}
	}
}


class StandardBlock{
	int y, x;// 무지개블록 : blockNum = 7

	public StandardBlock(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
class Block{
	int size, rainbowSize, standardY, standardX;

	public Block(int size, int rainbowSize, int standardY, int standardX) {
		this.size = size;
		this.rainbowSize = rainbowSize;
		this.standardY = standardY;
		this.standardX = standardX;
	}
}

class RemoveBlock{
	int y, x;

	public RemoveBlock(int y, int x) {
		this.y = y;
		this.x = x;
	}
}