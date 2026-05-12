//use trie to implement the prefix tree
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}
class WordDictionary {
    //. can match with any letter
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        //start from the 0th index, find if it contains
        return dfs(root, word, 0);
    }
    private boolean dfs(TrieNode node, String word, int index) {
    // 1. 基准情况：如果已经遍历完单词长度
    if (index == word.length()) {
        return node.isEnd; // 必须返回当前节点是否是单词结尾
    }

    char c = word.charAt(index);

    if (c == '.') {
        // 2. 通配符情况：遍历所有子节点
        for (TrieNode child : node.children.values()) {
            // 只要有一个分支返回 true，整个搜索就是 true
            if (dfs(child, word, index + 1)) {
                return true; 
            }
        }
        // 注意：如果循环结束还没找到 true，这里必须返回 false
        return false; 
    } else {
        // 3. 普通字符情况
        TrieNode next = node.children.get(c);
        if (next == null) {
            return false; // 路径中断，直接返回 false
        }
        // 必须返回下一层递归的结果！
        return dfs(next, word, index + 1); 
    }
}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */