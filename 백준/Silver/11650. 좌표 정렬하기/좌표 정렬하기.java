import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int N = Integer.parseInt(br.readLine()); // 입력

        List<Point> coordinate = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point point = new Point(x, y);
            coordinate.add(point);
        }

        Collections.sort(coordinate);

        coordinate.forEach((p) -> {
            sb.append(p.toString()).append("\n");
        });

        System.out.println(sb);
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point p) {

        if (this.x > p.x) {
            return 1;
        } else if (this.x == p.x) {
            if (this.y > p.y) {
                return 1;
            }
        }
        return -1;
    }
}


