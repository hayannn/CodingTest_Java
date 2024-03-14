class Solution {
    public String solution(String p) {
        String answer;
        if(check(p)) return p;
        answer = split(p);
        return answer;
    }

    // "올바른 괄호 문자열"인지 확인하는 메서드
    public static boolean check(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    // "균형잡힌 괄호 문자열" -> "올바른 괄호 문자열" 변환하는 메서드
    public static String split(String w) {
        if (w.isEmpty()) return "";

        int count = 0;
        int index = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                index = i;
                break;
            }
        }

        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);

        if (check(u)) {
            return u + split(v);
        } else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(split(v));
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    // u를 변환하는 메서드
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                reversed.append(')');
            } else {
                reversed.append('(');
            }
        }
        return reversed.toString();
    }
}
