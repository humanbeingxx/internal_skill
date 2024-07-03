package priv.cxs.classic150;

public class Question22 {

    public int strStr(String haystack, String needle) {
        int max = haystack.length() - needle.length();
        if (max < 0) {
            return -1;
        }
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                while (i <= max && haystack.charAt(i) != needle.charAt(0)){
                    i++;
                };
                if (i > max) {
                    return -1;
                }
            }
            int hp = i;
            int np = 0;
            while (np < needle.length() && haystack.charAt(hp) == needle.charAt(np)) {
                hp++;
                np++;
            }
            if (np == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = new Question22().strStr("mississippi", "a");
        System.out.println(result);
    }
}
