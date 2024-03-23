import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {
    static List<Dictionary> dictionaryList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기


        int N = Integer.parseInt(br.readLine());
        String[] aaa = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            aaa[i] = word;
        }
        List<String> list = Arrays.asList(aaa);
        Set<String> set = new HashSet<>(list);
        List<String> newList = new ArrayList<>(set);

        for (int i = 0; i < newList.size(); i++) {
            dictionaryList.add(new Dictionary(newList.get(i)));
        }

        dictionaryList.sort(new Comparator<Dictionary>() {
            @Override
            public int compare(Dictionary o1, Dictionary o2) {
                if (o1.getWord().length()> o2.getWord().length()) {
                    return 1;
                } else if (o1.getWord().length() == o2.getWord().length()) {
                    if (o1.getWord().compareTo(o2.getWord()) > 0) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        dictionaryList.forEach((p) -> {
            sb.append(p.toString()).append("\n");
        });


        System.out.println(sb.toString());
    }
}

class Dictionary{
    String word;

    public Dictionary(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }

}

