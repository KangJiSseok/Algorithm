import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hashing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] dp = new long[51];
	public static void main(String[] args) throws Exception {
		br.readLine();
		String s = br.readLine();
		long result = 0;

		dp[0] = 1;
		for (int i = 1; i <= 50; i++) {
			dp[i] = (dp[i - 1] * 31) % 1234567891;
		}

		for (int i = 0; i < s.length(); i++) {
			result = (result + (s.charAt(i) - 'a' + 1) * dp[i]) % 1234567891;
		}
		System.out.println(result);

	}
}
