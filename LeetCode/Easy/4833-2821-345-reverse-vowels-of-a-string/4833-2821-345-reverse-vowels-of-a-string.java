import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(str[i])) i++;
            while (i < j && !vowels.contains(str[j])) j--;
            
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

            i++;
            j--;
        }
        return new String(str);
    }
}
