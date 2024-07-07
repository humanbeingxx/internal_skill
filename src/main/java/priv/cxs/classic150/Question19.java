package priv.cxs.classic150;

public class Question19 {

    public int lengthOfLastWord(String s) {
        int len = 0;
        int pos = s.length() - 1;
        while (s.charAt(pos) == ' ') {
            pos--;
        }
        while (pos >= 0 && s.charAt(pos) != ' ') {
            pos--;
            len++;
        }
        return len;
    }
}
