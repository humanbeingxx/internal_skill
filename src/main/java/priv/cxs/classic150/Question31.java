package priv.cxs.classic150;

import java.util.HashSet;
import java.util.Set;

public class Question31 {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int maxLen = 0, left = 0;
        Set<Character> saw = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            while (saw.contains(c) && left < i) {
                saw.remove(s.charAt(left));
                left++;
            }
            saw.add(c);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
