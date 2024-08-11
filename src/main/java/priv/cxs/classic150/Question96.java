package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Question96 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Map<String, Integer> paths = buildPaths(endWord, words);
        int min = Integer.MAX_VALUE;
        if (paths.containsKey(beginWord)) {
            min = paths.get(beginWord);
        }
        List<String> reach = reach(beginWord, words);
        for (String s : reach) {
            if (paths.containsKey(s)) {
                min = Math.min(min, paths.get(s) + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }

    private Map<String, Integer> buildPaths(String endWord, Set<String> words) {
        Map<String, Integer> wordsPath = new HashMap<>();
        Set<String> checked = new HashSet<>();
        wordsPath.put(endWord, 0);
        checked.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(endWord);
        int len = 1;
        while (!queue.isEmpty() && !words.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> nexts = reach(poll, words);
                for (String next : nexts) {
                    if (checked.contains(next)) {
                        continue;
                    }
                    wordsPath.put(next, len);
                    queue.add(next);
                    checked.add(next);
                }
            }
            len++;
        }
        return wordsPath;
    }


    private List<String> reach(String end, Set<String> words) {
        List<String> result = new ArrayList<>();
        char[] chars = end.toCharArray();
        for (int i = 0; i < end.length(); i++) {
            char c = end.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (c != j) {
                    chars[i] = j;
                    String newString = new String(chars);
                    if (words.contains(newString)) {
                        result.add(newString);
                    }
                }
            }
            chars[i] = c;
        }
        return result;
    }
}
