import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String poly = br.readLine();

        // 현재 X개수
        int count = 0;
        int finalCount = 0;

        int remainder = 0;

        int fourDivision = 0;
        int twoDivision = 0;

        boolean result = true;  //성공 실패


        for (int i = 0; i < poly.length(); i++) {
            // .전까지의 X개수 (탐욕 알고리즘 작성)
            if (poly.charAt(i) == '.') {
                finalCount++;

                fourDivision = count / 4;   //4로 나눈 값
                remainder = count - fourDivision * 4;   //4로 나눈 몫

                twoDivision = remainder / 2;  // 2로 나눈 값
                remainder = remainder - twoDivision * 2;    //2로 나눈 몫

                if (remainder != 0) {
                    result = false;
                }
                for (int k = 0; k < fourDivision; k++) sb.append("AAAA");
                for (int k = 0; k < twoDivision; k++) sb.append("BB");
                count = 0;
                sb.append(".");
            }
            else{
                count++;
                finalCount++;
            }
            //문자 마지막은 .이 없다
            if (poly.length() == finalCount) {
                fourDivision = count / 4;   //4로 나눈 값
                remainder = count - fourDivision * 4;   //4로 나눈 몫

                twoDivision = remainder / 2;  // 2로 나눈 값
                remainder = remainder - twoDivision * 2;    //2로 나눈 몫

                if (remainder != 0) {
                    result = false;
                }
                for (int k = 0; k < fourDivision; k++) sb.append("AAAA");
                for (int k = 0; k < twoDivision; k++) sb.append("BB");
            }


        }

        if (result == false) {
            System.out.println("-1");
            return;
        }
        System.out.println(sb);
    }
}