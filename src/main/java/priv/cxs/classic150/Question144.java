package priv.cxs.classic150;

public class Question144 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int index1 = i - 1, index2 = j - 1, index3 = index1 + index2 + 1;
                if (index1 >= 0 && s1.charAt(index1) == s3.charAt(index3)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (index2 >= 0 && s2.charAt(index2) == s3.charAt(index3)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
