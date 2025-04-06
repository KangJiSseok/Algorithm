import java.io.*;

public class 벌집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 1;
		int mul = 6;
		int multiple;
		int i = 1;
		int n = 1;
		while (n < N) {
			multiple = i++ * mul;
			n += multiple;
			count++;
		}

		System.out.println(count);
	}
}

/**
 * 1		1		1
 * 2~7		6		2
 * 8~19		12		3
 * 20~37	18		4
 * 38~61	24		5
 * ...
 */