//create a trie class prefix tree
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    public TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}
class Trie {
    
    //check if it contains in the trie
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    //insert into the Trie
    public void insert(String word) {
        //insert the word from the beginning
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
    //check if contains in the trie
    public boolean search(String word){
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEnd;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //iterate in the s
        //create a trie with wordDict
        //check if can find the string in the trie
        //if the word doesn't match -> 1. isEnd in the trie, still true
        //2. isEnd is false, break the loop to search for a new word
        //3.if reach end of the s, but isEnd is still false, return false
        //if cannot find the word in trie, return false
        //over all return true
        Trie trie = new Trie();
        //implement the trie
        for (String word: wordDict) {
            trie.insert(word);
        }

        int l = 0;
        for (int r = 0; r<s.length(); r++) {
            String word = s.substring(l, r+1);
            if (trie.search(word)) {
                l = r+1;
            }else if (!trie.search(word) && r < s.length() - 1 ){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}