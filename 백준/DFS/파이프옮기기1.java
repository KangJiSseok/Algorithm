import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int[][] board;
	static int N, result = 0;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for(int i=0; i< N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0 : 가로, 1 : 세로, 2 : 대각선
		int dir = 0;
		dfs(0, 1, dir);
		System.out.println(result);

	}
	static void dfs(int y, int x, int dir){

		if(y == N - 1 && x == N - 1){
			result++;
			return;
		}
		switch(dir){
			case 0 :
				if(0<= y && y < N && 0<= x + 1 && x + 1 < N && board[y][x+1] == 0) dfs(y, x + 1, 0);
				if(0<= y + 1 && y + 1 < N && 0<= x + 1 && x + 1 < N
					&& board[y+1][x+1] == 0
					&& board[y][x+1] == 0
					&& board[y+1][x] == 0) dfs(y + 1, x + 1, 2);
				break;
			case 1 :
				if(0<= y + 1 && y + 1 < N && 0<= x && x < N && board[y+1][x] == 0) dfs(y+1, x, 1);
				if(0<= y + 1 && y + 1 < N && 0<= x + 1 && x + 1< N
					&& board[y+1][x+1] == 0
					&& board[y][x+1] == 0
					&& board[y+1][x] == 0) dfs(y+1,x+1, 2);
				break;
			case 2 :
				if(0<= y && y < N && 0<= x + 1 && x + 1 < N && board[y][x+1] == 0) dfs(y, x + 1, 0);
				if(0<= y + 1 && y + 1 < N && 0<= x && x < N && board[y+1][x] == 0) dfs(y + 1, x, 1);
				if(0<= y + 1 && y + 1 < N && 0<= x + 1&& x + 1 < N
					&& board[y+1][x+1] == 0
					&& board[y][x+1] == 0
					&& board[y+1][x] == 0) dfs(y + 1, x + 1, 2);
				break;
		}

		return;
	}
}
