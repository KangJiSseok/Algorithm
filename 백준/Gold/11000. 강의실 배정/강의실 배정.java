import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> timeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timeList.add(new int[]{start, 1});
            timeList.add(new int[]{end, -1});
        }

        timeList.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int maxCnt = 0;
        int cnt = 0;
        int pos = -1;

        for (int[] time : timeList) {
            if (pos != time[0]) {
                maxCnt = Math.max(maxCnt, cnt);
                pos = time[0];
            }
            cnt += time[1];
        }

        maxCnt = Math.max(maxCnt, cnt);
        System.out.println(maxCnt);
    }
}
