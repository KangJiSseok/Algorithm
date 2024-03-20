import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int sum = 0;

    static int[] smallPeople = new int[9];
    static int[] resultPeople = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder에 하나씩 붙여놓고 한 번에 출력하기

        for (int i = 0; i < 9; i++) {
            smallPeople[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                for (int k = j + 1; k < 9; k ++) {
                    for (int l = k + 1; l < 9; l++) {
                        for (int m = l + 1; m < 9; m++) {
                            for (int n = m + 1; n < 9; n++) {
                                for (int o = n + 1; o < 9; o++) {
                                    sum = smallPeople[i] +
                                            smallPeople[j] +
                                            smallPeople[k] +
                                            smallPeople[l] +
                                            smallPeople[m] +
                                            smallPeople[n] +
                                            smallPeople[o];
                                    if (sum == 100) {
                                        resultPeople[0] = smallPeople[i];
                                        resultPeople[1] = smallPeople[j];
                                        resultPeople[2] = smallPeople[k];
                                        resultPeople[3] = smallPeople[l];
                                        resultPeople[4] = smallPeople[m];
                                        resultPeople[5] = smallPeople[n];
                                        resultPeople[6] = smallPeople[o];
                                        Arrays.sort(resultPeople);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(resultPeople[i]);
        }
    }
}