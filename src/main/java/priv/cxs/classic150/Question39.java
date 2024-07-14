package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question39 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> scount = count(s);
        Map<Character, List<Integer>> tcount = count(t);
        if (scount.size() != tcount.size()) {
            return false;
        }
        return scount.values().containsAll(tcount.values());
    }

    private Map<Character, List<Integer>> count(String s) {
        Map<Character, List<Integer>> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!count.containsKey(c)) {
                count.put(c, new ArrayList<>());
            }
            count.get(c).add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        boolean result = new Question39().isIsomorphic("bbbaaaba", "aaabbbba");
        System.out.println(result);
    }
}
