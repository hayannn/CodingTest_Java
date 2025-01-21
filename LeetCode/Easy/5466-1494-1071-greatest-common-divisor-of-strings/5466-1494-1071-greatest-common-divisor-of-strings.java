class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        if (!(str1.startsWith(str2) && str1.endsWith(str2)) &&
            !(str2.startsWith(str1) && str2.endsWith(str1))) return "";
        return str2.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
