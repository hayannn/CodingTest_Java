class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        char[] result = new char[len1 + len2];
        
        int index = 0;
        int i = 0;

        while (i < len1 || i < len2) {
            if (i < len1) result[index++] = word1.charAt(i);
            if (i < len2) result[index++] = word2.charAt(i);
            i++;
        }
        return new String(result);
    }
}