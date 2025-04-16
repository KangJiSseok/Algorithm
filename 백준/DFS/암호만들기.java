import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static char[] arr, result;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		result = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, 0);

		System.out.println(sb);
	}

	public static void dfs(int index,int depth) {
		if (depth == L) {
			boolean vowel = vowel();
			boolean consonant = consonant();

			if(vowel && consonant)
				sb.append(String.valueOf(result)).append("\n");
			return;
		}

		for (int i = index; i < C; i++) {
			result[depth] = arr[i];
			dfs(i + 1, depth + 1);
		}
	}

	public static boolean vowel() {
		for (char c : result) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		}
		return false;
	}

	public static boolean consonant() {
		int count = 0;
		for (char c : result) {
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') count++;
		}

		if(count >= 2) return true;
		else return false;
	}
}
