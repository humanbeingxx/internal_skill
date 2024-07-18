package priv.cxs.classic150;

import java.util.Arrays;

public class Question41 {

    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(countS, countT);
    }
}
