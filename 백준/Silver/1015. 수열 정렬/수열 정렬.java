import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int i = 0, j = 0;
        int temp;

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int[] A = new int[a];

        for (i = 0; i < a; i++) {
            A[i] = scanner.nextInt();
        }

        int[] B = new int[A.length];
        int[] P = new int[A.length];
        int[] P2 = new int[A.length];


        for (i = 0; i < A.length; i++) {
            B[i] = A[i];
        }

        for (i = 0; i < A.length; i++) {
            for (j = 0; j < (A.length - 1) - i; j++) {
                if (B[j] > B[j + 1]) {
                    temp = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = temp;
                }
            }
        }

        int k = 0;
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
                if (B[i] == A[j]) {
                    P[i] = j;
                    A[j] = 0;
                    break;
                }
            }
        }


        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A.length; j++) {
                if (P[i] == j) {
                    P2[j] = i;
                }
            }
        }

        for (i = 0; i < A.length; i++) {
            System.out.println(P2[i]);
        }
    }
}