import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String text;
            if((text = br.readLine()) == null){
                break;
            }
            st = new StringTokenizer(text);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");

        }
        System.out.println(sb.toString());
    }
}

