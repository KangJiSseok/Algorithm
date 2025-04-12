import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int multiple = 1;
		for (int mul = n, i = 1; i <= r; i++, mul--) {
			multiple *= mul;
		}

		int iter = r;
		for (int i = 0; i < iter; i++) {
			multiple /= r--;
		}

		System.out.println(multiple);
	}
}
