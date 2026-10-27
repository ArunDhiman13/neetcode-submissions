

class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (String s : strs) {
            result.append(s.length());
            result.append("#");
            result.append(s);
        }

        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Length of current string
            int length = Integer.parseInt(str.substring(i, j));

            // Move to first character of actual string
            i = j + 1;

            // Extract string
            result.add(str.substring(i, i + length));

            // Move to next encoded string
            i = i + length;
        }

        return result;
    }
}
