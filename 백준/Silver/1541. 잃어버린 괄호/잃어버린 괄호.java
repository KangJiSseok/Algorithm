import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {

        //==========초기화==========//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int count = 0;
        while(st.hasMoreTokens()){
            int sum = 0;

            StringTokenizer newSt = new StringTokenizer(st.nextToken(), "+");

            while (newSt.hasMoreTokens()) {
                sum += Integer.parseInt(newSt.nextToken());
            }

            if (count > 0) {
                result -=sum;
            }else{
                result = sum;
            }
            count++;
        }

        System.out.println(result);
    }

}