import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기


        int N = Integer.parseInt(br.readLine());
        List<Point> coordinate = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinate.add(new Point(x, y));
        }

        Collections.sort(coordinate, (a,b) -> {
            if (a.getY() > b.getY()) {
                return 1;
            } else if (a.getY() == b.getY()) {
                if (a.getX() > b.getX()) {
                    return 1;
                }
            }
            return -1;
        });


        coordinate.forEach((p)->{
            sb.append(p.toString()).append("\n");
                }
        );

        System.out.println(sb.toString());
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}


