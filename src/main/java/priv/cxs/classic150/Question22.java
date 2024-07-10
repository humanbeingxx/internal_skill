package priv.cxs.classic150;

public class Question22 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder[] stringBuilders = new StringBuilder[length];
        for (int i = 0; i < length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int pos = 0;
        boolean increase = true;
        for (int i = 0; i < length; i++) {
            stringBuilders[pos].append(s.charAt(i));
            if (increase) {
                pos++;
                if (pos == numRows) {
                    pos -= 2;
                    increase = false;
                }
            } else {
                pos--;
                if (pos < 0) {
                    pos = 1;
                    increase = true;
                }
            }
        }
        for (int i = 1; i < length; i++) {
            stringBuilders[0].append(stringBuilders[i]);
        }
        return stringBuilders[0].toString();
    }
}
