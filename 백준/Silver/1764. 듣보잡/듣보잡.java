import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 0;

        String text = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");

        String N = stringTokenizer.nextToken();
        String M = stringTokenizer.nextToken();

        String array[] = new String[Integer.parseInt(N)];

        for (int i = 0; i < Integer.parseInt(N); i++) {
            array[i] = br.readLine();
        }

        //배열 오름차순 정렬
        Arrays.sort(array);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(M); i++) {
            int idx = Arrays.binarySearch(array, br.readLine());
            if (idx >= 0) {
                list.add(array[idx]);
            }
        }


        Collections.sort(list);

        sb.append(list.size()).append('\n');
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}