import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> midLowTree = new TreeMap<>();
        TreeMap<Integer, Integer> midHighTree = new TreeMap<>();
        int lowSize = 0;
        int highSize = 0;

        int midValue = Integer.parseInt(br.readLine());
        sb.append(midValue).append("\n");
        midLowTree.put(midValue, 1);
        lowSize++;

        for (int i = 1; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value <= midLowTree.lastKey()) {
                midLowTree.put(value, midLowTree.getOrDefault(value, 0) + 1);
                lowSize++;
            } else {
                midHighTree.put(value, midHighTree.getOrDefault(value, 0) + 1);
                highSize++;
            }

            if (lowSize < highSize) {
                Map.Entry<Integer, Integer> getEntry = midHighTree.firstEntry();
                if (getEntry.getValue() - 1 == 0) {
                    midHighTree.remove(getEntry.getKey());
                } else {
                    midHighTree.put(getEntry.getKey(), getEntry.getValue() - 1);
                }
                midLowTree.put(getEntry.getKey(), midLowTree.getOrDefault(getEntry.getKey(), 0) + 1);
                lowSize++;
                highSize--;
            } else if (lowSize > highSize + 1) {
                Map.Entry<Integer, Integer> getEntry = midLowTree.lastEntry();
                if (getEntry.getValue() - 1 == 0) {
                    midLowTree.remove(getEntry.getKey());
                } else {
                    midLowTree.put(getEntry.getKey(), getEntry.getValue() - 1);
                }
                midHighTree.put(getEntry.getKey(), midHighTree.getOrDefault(getEntry.getKey(), 0) + 1);
                lowSize--;
                highSize++;
            }
            sb.append(midLowTree.lastKey() + "\n");
        }

        System.out.println(sb.toString());
    }
}
