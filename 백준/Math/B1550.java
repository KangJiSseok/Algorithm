import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1550 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		map.put('A', 10);
		map.put('B', 11);
		map.put('C', 12);
		map.put('D', 13);
		map.put('E', 14);
		map.put('F', 15);

		int potent = 0;
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			result += map.get(s.charAt(i)) * Math.pow(16, potent++);
		}

		System.out.println(result);
	}
}
