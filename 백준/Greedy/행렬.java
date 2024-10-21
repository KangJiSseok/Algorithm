import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 행렬 {
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[a][b];
        int[][] compare = new int[a][b];

        for (int i = 0; i < a; i++) {
            String text = br.readLine();
            for (int j = 0; j < b; j++) {
                board[i][j] = text.charAt(j) - '0';
            }
        }

        for (int i = 0; i < a; i++) {
            String text = br.readLine();
            for (int j = 0; j < b; j++) {
                compare[i][j] = text.charAt(j) - '0';
            }
        }

        for (int i = 0; i < a - 2; i++) {
            for (int j = 0; j < b - 2; j++) {
                if(board[i][j] != compare[i][j]) {
                    count++;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            board[i + k][j + l] = board[i + k][j + l] ^ 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(board[i][j] != compare[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }
}
