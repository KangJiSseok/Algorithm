import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int N;
    static int R;
    static int C;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        dfs(0, 0, size);

        System.out.println(result);
    }

    private static void dfs(int r, int c, int size) {
        if (size == 1)
            return;
        int newSize = size / 2;

        if (R < r + newSize && C < c + newSize) {
            dfs(r, c, newSize);
        } else if (R < r + newSize && c + newSize <= C) {
            result += (size*size) / 4;
            dfs(r, c + newSize, newSize);
        } else if (r + newSize <= R && C < c + newSize) {
            result += (size*size) / 4 * 2;
            dfs(r + newSize, c, newSize);
        }else{
            result += (size * size) / 4 * 3;
            dfs(r + newSize, c + newSize, newSize);
        }
    }
}
