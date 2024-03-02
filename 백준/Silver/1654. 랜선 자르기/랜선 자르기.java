import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String firstLine = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(firstLine, " ");
        String kChar = stringTokenizer.nextToken();
        String nChar = stringTokenizer.nextToken();

        int K = Integer.parseInt(kChar);
        int N = Integer.parseInt(nChar);

        // 정렬 완료
        ArrayList<Integer> lan = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            lan.add(Integer.parseInt(br.readLine()));
        }
        lan.sort(Comparator.naturalOrder());


        // 이진 탐색 시작
        System.out.println(binarySearch(lan,N));
    }

    static Long binarySearch(ArrayList<Integer> lan, int N) {

        Long mid;
        Long min = 1L;
        Long max = Long.valueOf(lan.get(lan.size() - 1));

        while (min <= max) {
            mid = (min + max) / 2;
            int count = 0;

            for (int data : lan) {
                count += data / mid;
            }

            if (count < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (max + min) / 2;
    }
}