import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();

        Map<Integer, String> poketmon1 = new LinkedHashMap();
        Map<String, Integer> poketmon2 = new LinkedHashMap();

        String text = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");

        int first = Integer.parseInt(stringTokenizer.nextToken());
        int second = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= first; i++) {
            String poketmonPut = br.readLine();
            poketmon1.put(i, poketmonPut);
            poketmon2.put(poketmonPut, i);
        }

        for (int i = 0; i < second; i++) {
            String secondRead = br.readLine();

            try {
                int secondInt = Integer.parseInt(secondRead);
                bw.write(poketmon1.get(secondInt)+"\n");
            } catch (NumberFormatException e) {
                bw.write(String.valueOf(poketmon2.get(secondRead))+"\n");
            }
        }
        bw.flush();
        br.close();
    }
}