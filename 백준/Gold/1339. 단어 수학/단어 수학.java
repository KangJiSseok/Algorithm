import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] numberList = new char[N][8];
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            Arrays.fill(numberList[i], '0');
        }


        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int size = input.length();
            for (int j = 0; j < size; j++) {
                numberList[i][8 - size + j] = input.charAt(j);
            }
        }

        int mul = 10000000;
        for (int i = 0; i < 8; i++) {
//            System.out.println("mul = " + mul);
            for (int j = 0; j < N; j++) {
                if (numberList[j][i] != '0') {
                    //key가 있으면
                    if (map.containsKey(numberList[j][i])) {
                        Integer get = map.get(numberList[j][i]);
                        map.put(numberList[j][i], mul + get);
                    } else {
                        map.put(numberList[j][i], mul);
                    }
                }
            }
            mul /= 10;
        }

//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int num = 9;
        for (Map.Entry<Character, Integer> entry : list) {
//            System.out.println("char : " + entry.getKey() + " value : " + entry.getValue());
            map.put(entry.getKey(), num);
            num--;
        }

//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println("char : " + entry.getKey() + " value : " + entry.getValue());
//        }



//        int number = 9;
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < N; j++) {
//                if(numberList[j][i] != 0){
//                    if (!map.containsKey(numberList[j][i])) {
//                        map.put(numberList[j][i], number);
//                        number--;
//                    }
//                }
//            }
//        }
//
        for (int i = 0; i < N; i++) {
            String text = "";
            for (int j = 0; j < 8; j++) {
                if (numberList[i][j] != '0') {
                    text += map.get(numberList[i][j]);
                }
            }
            result += Integer.parseInt(text);
        }
//
        System.out.println(result);
    }
}