import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N != 1) {
			for (int i = 2; i <= N; i++) {
				if(i == N){
					N /= i;
					sb.append(i).append("\n");
					System.out.println(sb);
					return;
				}
				else if(N % i == 0){
					N /= i;
					sb.append(i).append("\n");
					break;
				}
			}
		}
	}
}
