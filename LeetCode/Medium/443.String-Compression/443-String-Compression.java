class Solution {
    public int compress(char[] chars) {
        int idx = 0, cnt = 1;
        
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                cnt++;
            } else {
                chars[idx++] = chars[i - 1];
                if (cnt > 1) {
                    for (char c : String.valueOf(cnt).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                cnt = 1;
            }
        }
        return idx;
    }
}
