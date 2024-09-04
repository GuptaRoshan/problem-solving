package neetcode150.tries;

class WordDictionary_211 {

    private final WordDictionary_211[] children;
    boolean isEndOfWord;

    // Initialize your data structure here.
    public WordDictionary_211() {
        children = new WordDictionary_211[26];
        isEndOfWord = false;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        WordDictionary_211 curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new WordDictionary_211();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary_211 curr = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                // search with all possible children, skipping the current char
                for (WordDictionary_211 ch : curr.children) {
                    // ch.search(word.substring(i + 1) skips the first char and searches with the rest of the string, at each level
                    if (ch != null && ch.search(word.substring(i + 1))) return true;
                }
                return false;
            }
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }

        return curr != null && curr.isEndOfWord;
    }

    public static void main(String[] args){
        WordDictionary_211 wordDictionary = new WordDictionary_211();
        wordDictionary.addWord("blm");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }

}
