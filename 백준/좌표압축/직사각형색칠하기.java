import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 직사각형색칠하기 {
    static int N;
    static int K;

    static int[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[N][4];

        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
            pos[i][2] = Integer.parseInt(st.nextToken());
            pos[i][3] = Integer.parseInt(st.nextToken());

            rectangles.add(new Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3], i + 1));
        }

        HashSet<Integer> XSet = new HashSet<>();
        for (Rectangle rect : rectangles) {
            XSet.add(rect.x1);
            XSet.add(rect.x2);
        }
        Integer[] XList = XSet.toArray(new Integer[0]);
        Arrays.sort(XList);

        HashSet<Integer> YSet = new HashSet<>();
        for (Rectangle rect : rectangles) {
            YSet.add(rect.y1);
            YSet.add(rect.y2);
        }
        Integer[] YList = YSet.toArray(new Integer[0]);
        Arrays.sort(YList);

        int[][] comPress = new int[YList.length][XList.length];

        for (Rectangle rectangle : rectangles) {
            int x1 = Arrays.binarySearch(XList, rectangle.x1);
            int y1 = Arrays.binarySearch(YList, rectangle.y1);
            int x2 = Arrays.binarySearch(XList, rectangle.x2);
            int y2 = Arrays.binarySearch(YList, rectangle.y2);

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    comPress[i][j] = Math.max(comPress[i][j], rectangle.index);
                }
            }
        }

        int[] areaArray = new int[N + 1];
        for (int i = 0; i < YList.length; i++) {
            for (int j = 0; j < XList.length; j++) {
                int rectValue = comPress[i][j];
                if (rectValue > 0) {
                    int width = XList[j + 1] - XList[j];
                    int height = YList[i + 1] - YList[i];
                    areaArray[rectValue] += width * height;
                }
            }
        }

        List<Integer> compareList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            compareList.add(i);
        }
        compareList.sort((a, b) -> Integer.compare(areaArray[b], areaArray[a]));

        List<Integer> resultList = compareList.subList(0, K);
        Collections.sort(resultList);
        for (Integer index : resultList) {
            System.out.print(index + " ");
        }
    }

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;
        int index;

        public Rectangle(int x1, int y1, int x2, int y2, int index) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.index = index;
        }
    }
}
