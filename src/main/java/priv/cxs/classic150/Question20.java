package priv.cxs.classic150;

public class Question20 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }
}
