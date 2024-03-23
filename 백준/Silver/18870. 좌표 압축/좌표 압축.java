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
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> coordinateList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            coordinateList.add(Integer.valueOf(st.nextToken()));
        }

        //중복 제거
        Set<Integer> set = new HashSet<>(coordinateList);
        List<Integer> rangeCoordinateList = new ArrayList<>(set);

        Collections.sort(rangeCoordinateList);

        Map<Integer, Integer> comparable = new HashMap<>();

        for (int i = 0; i < rangeCoordinateList.size(); i++) {
            comparable.put(rangeCoordinateList.get(i),i);
        }

        coordinateList.forEach((p) -> {
            sb.append(comparable.get(p)).append(" ");
        });

        System.out.println(sb);
    }
}

