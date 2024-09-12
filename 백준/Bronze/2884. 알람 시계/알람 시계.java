import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int total = 60 * hour + minute;

        if (total - 45 < 0) {
            total = 60 * 24 + (total % 60 - 45);
        }else{
            total -= 45;
        }

        System.out.println(total / 60 + " " + total % 60);
    }
}

