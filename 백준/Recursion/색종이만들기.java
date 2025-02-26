import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
	static int[][] board;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];

		for(int i=1; i <= N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j= 1; j <= N; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int[] ints = dfs(1, N, 1, N);
		System.out.println(ints[1]); // white
		System.out.println(ints[0]); // blue
	}

	static int[] dfs(int sy, int ey, int sx, int ex){
		int[] ints = isVaildAndColorCount(sy, ey, sx, ex);

		if (ints[2] == 1) {
			return new int[]{ints[0], ints[1]};
		} else {
			int midY = (sy + ey) / 2;
			int midX = (sx + ex) / 2;

			int[] topRight   = dfs(sy,      midY,     midX+1, ex);
			int[] bottomRight= dfs(midY+1,  ey,       midX+1, ex);
			int[] bottomLeft = dfs(midY+1,  ey,       sx,     midX);
			int[] topLeft    = dfs(sy,      midY,     sx,     midX);

			ints[0] = topRight[0] + bottomRight[0] + bottomLeft[0] + topLeft[0];
			ints[1] = topRight[1] + bottomRight[1] + bottomLeft[1] + topLeft[1];

			return new int[]{ints[0], ints[1]};
		}
	}


	static int[] isVaildAndColorCount(int sy, int ey, int sx, int ex){
		int blue = 0;
		int white = 0;
		for(int i= sy; i<= ey; i++){
			for(int j = sx; j<= ex; j++){
				if(board[i][j] == 0) white++;
				else blue++;
			}
		}
		if(white != 0 && blue == 0) return new int[]{0, 1, 1};
		else if(white == 0 && blue != 0) return new int[]{1, 0, 1};
		else return new int[]{0,0,0};
	}
}
