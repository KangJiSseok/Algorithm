import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B30020 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		if (A <= B || 2 * B < A) {
			System.out.println("NO");
			return;
		}

		sb.append("YES").append("\n");

		A -= (B + 1);

		sb.append(A + 1).append("\n");

		for (int i = 0; i < A; i++) {
			sb.append("aba").append("\n");
		}

		sb.append("a");
		for (int i = 0; i < B - A; i++) {
			sb.append("ba");
		}

		System.out.println(sb);
	}
}
