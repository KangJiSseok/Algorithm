import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class B14725 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Main.Trie trie = new Main.Trie();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			List<String> list = new ArrayList<>();
			for (int j = 0; j < K; j++) {
				list.add(st.nextToken());
			}

			trie.insert(list);
		}

		trie.printTrie();

		System.out.println(sb);
	}

	static class Trie {
		Main.Node root;

		Trie() {
			root = new Main.Node();
		}

		void insert(List<String> words) {
			Main.Node current = root;
			for (String word : words) {
				current.child.putIfAbsent(word, new Main.Node());
				current = current.child.get(word);
			}
			current.endOfWord = true;
		}

		void printTrie() {
			printDFS(root, 0);
		}

		void printDFS(Main.Node node, int depth) {
			List<String> keys = new ArrayList<>(node.child.keySet());
			Collections.sort(keys);

			for (String key : keys) {
				for (int i = 0; i < depth; i++) sb.append("--");
				sb.append(key).append("\n");
				printDFS(node.child.get(key), depth + 1);
			}
		}
	}

	static class Node {
		HashMap<String, Main.Node> child = new HashMap<>();
		boolean endOfWord;

		Node() {
			endOfWord = false;
		}
	}
}
