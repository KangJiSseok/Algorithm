import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B25191 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int chicken = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int coca = Integer.parseInt(st.nextToken());
		int macsu = Integer.parseInt(st.nextToken());

		int maxCoca = coca / 2;

		if(chicken >= maxCoca + macsu){
			System.out.println(maxCoca + macsu);
		}else{
			System.out.println(chicken);
		}
}
