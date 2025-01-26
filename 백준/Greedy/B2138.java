import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] firstArr = new int[100001];
		int[] resultArr = new int[100001];
		String a = br.readLine();
		String b = br.readLine();
		for (int i = 0; i < a.length(); i++) {
			firstArr[i] = a.charAt(i) - '0';
			resultArr[i] = b.charAt(i) - '0';
		}

		int[] oneSwitch = new int[100001];
		int[] twoSwitch = new int[100001];
		for (int i = 0; i < 100001; i++) {
			oneSwitch[i] = firstArr[i];
			twoSwitch[i] = firstArr[i];
		}
		oneSwitch[0] ^= 1;
		oneSwitch[1] ^= 1;
		int oneSwitchCount = 1;
		int twoSwitchCount = 0;

		for (int i = 1; i < N; i++) {
			if (oneSwitch[i - 1] != resultArr[i - 1]) {
				oneSwitchCount++;
				oneSwitch[i - 1] ^= 1;
				oneSwitch[i] ^= 1;
				oneSwitch[i + 1] = (i + 1 == N) ? oneSwitch[i + 1] : oneSwitch[i + 1] ^ 1;
			}

			if (twoSwitch[i - 1] != resultArr[i - 1]) {
				twoSwitchCount++;
				twoSwitch[i - 1] ^= 1;
				twoSwitch[i] ^= 1;
				twoSwitch[i + 1] = (i + 1 == N) ? twoSwitch[i + 1] : twoSwitch[i + 1] ^ 1;
			}
		}

		boolean oneB = Arrays.equals(oneSwitch, resultArr);
		boolean twoB = Arrays.equals(twoSwitch, resultArr);
		if (oneB && twoB) {
			System.out.println(Math.min(oneSwitchCount, twoSwitchCount));
		} else if (oneB) {
			System.out.println(oneSwitchCount);
		} else if (twoB) {
			System.out.println(twoSwitchCount);
		}else{
			System.out.println(-1);
		}
	}
}
