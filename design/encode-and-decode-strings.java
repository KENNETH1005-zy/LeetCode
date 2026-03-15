public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (String str: strs) {
            result += str;
            result += " ";
        }
        return result.trim();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] result= s.split(" ");
        return Arrays.asList(result);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));