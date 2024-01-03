import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String readLine = br.readLine();

        char[] charArray = readLine.toCharArray();

        Arrays.sort(charArray);

        int[] intArray = new int[charArray.length];

        int three =0;

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
            three += intArray[i];
        }

        if (readLine.contains("0") && three % 3 == 0) {
            for (int i = intArray.length - 1; i >= 0; i--) {
                sb.append(intArray[i]);
            }
            System.out.println(sb);
        }
        else{
            System.out.println("-1");
        }
    }
}


