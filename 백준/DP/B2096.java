import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {
	static int[] board;
	static int[][] minDP;
	static int[][] maxDP;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[3];
		minDP = new int[2][3];
		maxDP = new int[2][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[0] = Integer.parseInt(st.nextToken());
			board[1] = Integer.parseInt(st.nextToken());
			board[2] = Integer.parseInt(st.nextToken());

			minDP[i % 2][0] = Math.min(minDP[(i - 1) % 2][0], minDP[(i - 1) % 2][1]) + board[0];
			minDP[i % 2][1] =
				Math.min(Math.min(minDP[(i - 1) % 2][0], minDP[(i - 1) % 2][1]), minDP[(i - 1) % 2][2]) + board[1];
			minDP[i % 2][2] = Math.min(minDP[(i - 1) % 2][1], minDP[(i - 1) % 2][2]) + board[2];

			maxDP[i % 2][0] = Math.max(maxDP[(i - 1) % 2][0], maxDP[(i - 1) % 2][1]) + board[0];
			maxDP[i % 2][1] =
				Math.max(Math.max(maxDP[(i - 1) % 2][0], maxDP[(i - 1) % 2][1]), maxDP[(i - 1) % 2][2]) + board[1];
			maxDP[i % 2][2] = Math.max(maxDP[(i - 1) % 2][1], maxDP[(i - 1) % 2][2]) + board[2];
		}

		int last = N % 2;
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(Math.max(maxDP[last][0], maxDP[last][1]), maxDP[last][2]))
			.append(" ")
			.append(Math.min(Math.min(minDP[last][0], minDP[last][1]), minDP[last][2]));

		System.out.println(sb.toString());
	}
}
