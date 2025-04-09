import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDLCM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd, lcm;
		gcd = gcd(a, b);
		lcm = lcm(a, b, gcd);

		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b, int gcd) {
		return a * b / gcd;
	}
}
