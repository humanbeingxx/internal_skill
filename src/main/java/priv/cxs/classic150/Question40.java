package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question40 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, List<Integer>> pp = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!pp.containsKey(c)) {
                pp.put(c, new ArrayList<>());
            }
            pp.get(c).add(i);
        }
        String[] words = s.split(" ");
        Map<String, List<Integer>> sp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!sp.containsKey(word)) {
                sp.put(word, new ArrayList<>());
            }
            sp.get(word).add(i);
        }
        return pp.size() == sp.size() && pp.values().containsAll(sp.values());
    }
}
