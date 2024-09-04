package neetcode150.tries;

public class PrefixTree_208 {

    private final TrieNode root;

    public PrefixTree_208() {
        root = new TrieNode();
    }

    // Inserts an element into the trie.
    public void insert(String word) {
        TrieNode dictionary = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (dictionary.children[ch - 'a'] == null) {
                dictionary.children[ch - 'a'] = new TrieNode();
            }
            dictionary = dictionary.children[ch - 'a'];
        }
        dictionary.isWord = true;
    }


    // Search an element in the trie.
    public boolean search(String word) {
        TrieNode dictionary = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (dictionary.children[ch - 'a'] == null) {
                return false;
            }
            dictionary = dictionary.children[ch - 'a'];
        }
        return dictionary.isWord;
    }

    // Find starts with substring in trie
    public boolean startsWith(String prefix) {
        TrieNode dictionary = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (dictionary.children[ch - 'a'] == null) {
                return false;
            }
            dictionary = dictionary.children[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        PrefixTree_208 trie = new PrefixTree_208();
        trie.insert("cat");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }

}
