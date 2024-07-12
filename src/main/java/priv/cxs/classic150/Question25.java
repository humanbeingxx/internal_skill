package priv.cxs.classic150;

public class Question25 {

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);

            if (!(c1 >= 'a' && c1 <= 'z') && !(c1 >= 'A' && c1 <= 'Z') && !(c1 >= '0' && c1 <= '9')) {
                start++;
                continue;
            }
            if (!(c2 >= 'a' && c2 <= 'z') && !(c2 >= 'A' && c2 <= 'Z') && !(c2 >= '0' && c2 <= '9')) {
                end--;
                continue;
            }
            if (c1 >= 'A' && c1 <= 'Z') {
                c1 += 'a' - 'A';
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                c2 += 'a' - 'A';
            }
            if (c1 != c2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
