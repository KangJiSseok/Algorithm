import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        int left = 1;
        int right = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());
        if (left == right)
        {
            for (int i = 0; i < J; i++) {
                int applePosition = Integer.parseInt(br.readLine());

                if (left == applePosition) {
                    continue;
                }

                int aa = applePosition - left;
                if (aa > 0) {
                    left += aa;
                    count += aa;
                }
                else{
                    left -= -aa;
                    count += -aa;
                }
            }
        }else{
            for (int i = 0; i < J; i++) {
                int applePosition = Integer.parseInt(br.readLine());

                if (left <= applePosition && applePosition <= right) {
                    continue;
                }

                int leftABS = Math.abs(applePosition - left);
                int rightABS = Math.abs(applePosition - right);

                // 오른쪽 바구니랑 더 가까움
                if (leftABS > rightABS) {
                    right = right + rightABS;
                    left = left + rightABS;
                    count = count + rightABS;
                }else{
                    left = left - leftABS;
                    right = right - leftABS;
                    count = count + leftABS;
                }
            }
        }
        System.out.println(count);
    }
}
