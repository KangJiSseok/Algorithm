import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] line;    //[][0] = S, [][1] = E
    public static void main(String args[]) throws IOException {

        //=========초기화=========//
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        line = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // C < S < E
        // S < E < C
        // S < C < E
        int result = 0;
        int C = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(C < line[i][0]){
                result += line[i][1] - line[i][0];
                C = line[i][1];
            }
            else if(line[i][0] < C && line[i][1] < C ){
                continue;
            }
            else if(C < line[i][1]){
                result += line[i][1] - C;
                C = line[i][1];
            }
        }

        System.out.println(result);
    }
}