import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팩토리얼0의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 1; i <= N; i++) {
			result += exponent(i);
		}

		System.out.println(result);
	}

	private static int exponent(int num) {
		int count = 0;
		while (num % 5 == 0) {
			num /= 5;
			count++;
		}
		return count;
	}
}
