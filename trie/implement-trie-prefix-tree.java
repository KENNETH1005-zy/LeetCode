class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;
    public TrieNode () {
        this.isWord = false;
        this.children = new HashMap<>();
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        //starting from root to iterate
        TrieNode trieNode = root;
        char[] chars = word.toCharArray();

        for (int i = 0; i< word.length(); i++) {
            char ch = chars[i];
            if (!trieNode.children.containsKey(ch)) {
                trieNode.children.put(ch, new TrieNode());
            }
            //move the pointer to the next
            trieNode = trieNode.children.get(ch);
        }
        trieNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char ch: word.toCharArray()) {
            if (!trieNode.children.containsKey(ch)) {
                return false;
            }
            trieNode = trieNode.children.get(ch);
        }
        return trieNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (char ch: prefix.toCharArray()) {
            if (!trieNode.children.containsKey(ch)) {
                return false;
            }
            trieNode = trieNode.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */