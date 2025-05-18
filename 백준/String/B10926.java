import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10926 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb.append(br.readLine()).append("??!");
		System.out.println(sb);
	}
}
