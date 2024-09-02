import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Trie trie = new Trie();
        for (int i = 0; i < phone_book.length; i++) {
            if (!trie.insert(phone_book[i])) {
                answer = false;
            }
        }

        return answer;
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