//using Node class to store a node array for the children
//and the Deque to store the string
//can add linkedlist to the result list
class Node {
    Node[] nodes;
    LinkedList<String> dq;
    public Node() {
        //node array to store 26 letters
        nodes = new Node[26];
        dq = new LinkedList<>();
    }
}
class Solution {
    private Node root = new Node();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String s: products) {
            insert(s);
        }
        return search(searchWord);
    }

    public void insert(String s) {
        Node node = root;
        for (char ch: s.toCharArray()) {
            int index = ch - 'a';

            if (node.nodes[index] == null) {
                node.nodes[index] = new Node();
            }
            //move to next
            node = node.nodes[index];
            node.dq.offer(s);
            if (node.dq.size() > 3) {
                node.dq.pollLast();
            }
        }
    }

    public List<List<String>> search(String word) {
        List<List<String>> result = new ArrayList<>();

        Node node = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (node!= null) {
                node = node.nodes[index];
            }
            result.add(node == null ? new ArrayList<>() : node.dq);
        }
        return result;
    }
}