import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			if(isCorrect(s)) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}

		System.out.println(sb);
	}

	private static boolean isCorrect(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(stack.isEmpty() || c == '('){
				stack.push(s.charAt(i));
			} else if (c == ')') {
				if (!stack.isEmpty()) {
					if(stack.peek() == '(') stack.pop();
				}else{
					return false;
				}
			}
		}

		if(stack.size() > 0) return false;
		return true;
	}
}
