import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15894 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Long.parseLong(br.readLine()) * 4);
	}
}
