import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 흙길보수하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1,o2) -> {
			if(o1[0] == o2[0]){
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});

		int last = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][0] > last) {
				last = arr[i][0];
				int tar = arr[i][1];
				while(last < tar){
					last += L;
					result++;
				}
			}

			if(last <  arr[i][1]){
				int tar = arr[i][1];
				while(last < tar){
					last += L;
					result++;
				}
			}

		}
		System.out.println(result);
	}

}

/**
 *
 *							x
 * .    M   M   M   M   M   .   .   M   M   M   M   .   M   M   M   M   .   .   .   .
 * 0    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20
 * 		1	1	1	2	2	2
 */

/**
 * L = 3;
 * 	x
 * 				x
 * 							x
 * 										x
 * 		1	1	1	2	2	2	3	3	3
 * 0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16
 * 		-	-	-	-
 * 			-	-	-	-	-	-
 */
