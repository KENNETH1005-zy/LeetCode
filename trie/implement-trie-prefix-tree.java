//using trienode class
class TrieNode{
    //boolean to determin it is the end of the word
    //map to store the children
    boolean isEnd;
    Map<Character, TrieNode> children;
    public TrieNode(){
        isEnd = false;
        children = new HashMap<>();
    }
}
class Trie {
    //use root as the first one in the trie
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        //using the pointer of root
        TrieNode trieNode = root;
        char[] chars = word.toCharArray();
        for (char c: chars) {
            if (!trieNode.children.containsKey(c)) {
                trieNode.children.put(c, new TrieNode());
            }
            //move the it's child node
            trieNode = trieNode.children.get(c);
        }
        trieNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (char c: word.toCharArray()) {
            if (!trieNode.children.containsKey(c)) {
                return false;
            }
            //move to next trieNode
            trieNode = trieNode.children.get(c);
        }
        return trieNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;

        for (char c: prefix.toCharArray()) {
            if (!trieNode.children.containsKey(c)) {
                return false;
            }
            trieNode = trieNode.children.get(c);
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