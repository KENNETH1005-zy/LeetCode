public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //use a sb to store each str in strs
        //for each str:{number + # + str}
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //for the s, determine the length that has already in the s
        //add the length of that s into the result list
        List<String> result = new ArrayList<>();
        int l = 0;
        while (l < s.length()) {
            int delimiter = s.indexOf("#", l);
            int length = Integer.parseInt(s.substring(l, delimiter));
            String str = s.substring(delimiter + 1, delimiter + 1 + length);
            result.add(str);
            l = delimiter + 1 + length;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));