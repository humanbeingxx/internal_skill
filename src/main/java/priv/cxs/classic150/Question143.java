package priv.cxs.classic150;

public class Question143 {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String contain = getPalindrome(s, i, true);
            if (contain.length() > longest.length()) {
                longest = contain;
            }
            String notContain = getPalindrome(s, i, false);
            if (notContain.length() > longest.length()) {
                longest = notContain;
            }
        }
        return longest;
    }

    private String getPalindrome(String s, int mid, boolean containMid) {
        int left, right;
        if (containMid) {
            left = mid - 1;
            right = mid + 1;
        } else {
            left = mid;
            right = mid + 1;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
