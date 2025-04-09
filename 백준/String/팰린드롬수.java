import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;
			if (palindrome(s))
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static boolean palindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

}
