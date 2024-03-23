import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {
    static List<Online> onlineList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            onlineList.add(new Online(age, name, i));
        }

        Collections.sort(onlineList, new Online());

        onlineList.forEach((p) -> {
            sb.append(p.toString()).append("\n");
        });

        System.out.println(sb.toString());
    }
}

class Online implements Comparator<Online> {

    int age;
    String name;

    int primaryKey;

    public Online(int age, String name, int primaryKey) {
        this.age = age;
        this.name = name;
        this.primaryKey = primaryKey;
    }

    public Online() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compare(Online o1, Online o2) {
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age == o2.age) {
            if (o1.primaryKey > o2.primaryKey) {
                return 1;
            }
        }
        return -1;
    }
}

