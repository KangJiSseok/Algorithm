import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pallen = br.readLine();

        boolean result = true;
        for (int i = 0; i < pallen.length(); i++) {
            if (pallen.charAt(i) == pallen.charAt(pallen.length() - i - 1)) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        if (result == true) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
