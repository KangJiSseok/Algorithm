
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(map.containsKey(br.readLine())){
                count ++;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}




