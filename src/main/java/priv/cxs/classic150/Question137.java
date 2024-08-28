package priv.cxs.classic150;

import java.util.Arrays;
import java.util.List;

public class Question137 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int wl = word.length();
                if (i - wl >= 0 && dp[i - wl]) {
                    dp[i] = cmp(s, i - wl, i - 1, word);
                    if (dp[i]) break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean cmp(String s, int start, int end, String word) {
        if (word.length() != end - start + 1) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != word.charAt(i - start)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Question137().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}
