package priv.cxs.classic150;

public class Question16 {

    /**
     * 字符 数值
     * I   1
     * V   5
     * X   10
     * L   50
     * C   100
     * D   500
     * M   1000
     */
    public int romanToInt(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            num += map(c);
            if (i > 0) {
                char cp = s.charAt(i - 1);
                if ((c == 'V' || c == 'X') && cp == 'I') {
                    num -= 1;
                    i--;
                } else if ((c == 'L' || c == 'C') && cp == 'X') {
                    num -= 10;
                    i--;
                } else if ((c == 'D' || c == 'M') && cp == 'C') {
                    num -= 100;
                    i--;
                }
            }
        }
        return num;
    }

    private int map(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
