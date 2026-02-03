class TrieNode {
    //boolean to detect this is the end of the TrieNode
    //neighbors to find the next node of the trieNode
    boolean isEnd;
    TrieNode[] neighbors;
    public TrieNode(){
        isEnd = false;
        neighbors = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    //insert the string
    public void insert(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if(current.neighbors[c - 'a'] == null) {
                current.neighbors[c - 'a'] = new TrieNode();
            }
            current = current.neighbors[c - 'a'];
        }
        current.isEnd = true;
    }
    public String find(String word) {
        TrieNode current = root;
        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if (current.neighbors[c - 'a'] == null) {
                return word;
            }
            current = current.neighbors[c - 'a'];
            if (current.isEnd) {
                return word.substring(0, i+1);
            }
        }
        return word;
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sArray = sentence.split(" ");
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }
        for (int word = 0; word <sArray.length; word++) {
            sArray[word] = trie.find(sArray[word]);
        }

        return String.join(" ", sArray);
    }
}