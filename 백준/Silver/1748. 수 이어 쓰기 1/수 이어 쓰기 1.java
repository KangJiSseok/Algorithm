import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        int plus = 1;	
        int ten = 10;	
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            
            if(i % ten == 0) {
                plus ++;
                ten *= 10;
            }
            result += plus;

        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
