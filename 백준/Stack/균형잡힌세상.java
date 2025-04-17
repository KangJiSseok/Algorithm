import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		while (true) {
			String s = br.readLine();
			if(s.charAt(0) == '.') break;
			if(isEquals(s))
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isEquals(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[') {
				stack.push(c);
			}
			else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') return false;
				stack.pop();
			}
			else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
