import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FizzBuzz {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int num = 0;

		if(isNumber(a)) num = Integer.parseInt(a) + 3;
		else if(isNumber(b)) num = Integer.parseInt(b) + 2;
		else if(isNumber(c)) num = Integer.parseInt(c) + 1;

		System.out.println(result(num));

	}

	private static boolean isNumber(String s) {
		return !(s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz"));
	}

	private static String result(int num) {
		if(num % 15 == 0) return "FizzBuzz";
		else if(num % 3 == 0) return "Fizz";
		else if(num % 5 == 0) return "Buzz";
		else return (String.valueOf(num));
	}
}
