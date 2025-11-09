package tries;
import java.util.*;
import java.util.Collections;

public class Tries {
    private TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

   
    public void insert(String word, int index) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a'; // 0-25 index
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
        node.indices.add(index);
    }


    public List<Integer> search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return Collections.emptyList();
            node = node.children[idx];
        }
        return node.isWord ? node.indices : Collections.emptyList();}
    

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
}
