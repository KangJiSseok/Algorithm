import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (!trie.insert(br.readLine())) {
                    flag = false;
                }
            }
            sb.append(flag == true ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd;
    }

    static class Trie{
        Node root = new Node();

        boolean insert(String word) {
            Node currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode.child.get(c) == null) {
                    currentNode.child.put(c, new Node());
                }
                currentNode = currentNode.child.get(c);
                if(currentNode.isEnd == true) return false;
            }
            if(currentNode.child.size() !=0) return false;
            currentNode.isEnd = true;
            return true;
        }
    }

}