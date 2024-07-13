package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question32 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int wordsLen = wordLen * words.length;
        Map<String, Integer> originCount = new HashMap<>();
        for (String word : words) {
            originCount.put(word, originCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            if (i + wordsLen > s.length()) {
                break;
            }
            Map<String, Integer> wordCount = new HashMap<>(originCount);
            int left = i;
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                if (!wordCount.containsKey(word)) {
                    wordCount.putAll(originCount);
                    continue;
                }
                while (wordCount.getOrDefault(word, 0) == 0 && left < j) {
                    String leftWord = s.substring(left, left + wordLen);
                    if (wordCount.containsKey(leftWord)) {
                        wordCount.put(leftWord, wordCount.get(leftWord) + 1);
                    }
                    left += wordLen;
                }
                if (wordCount.getOrDefault(word, 0) == 0) {
                    wordCount.putAll(originCount);
                    continue;
                }
                wordCount.put(word, wordCount.get(word) - 1);
                if (all(wordCount)) {
                    result.add(j - wordsLen + wordLen);
                }
            }
        }
        return result;
    }

    public boolean all(Map<String, Integer> wordCount) {
        for (Integer value : wordCount.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> result = new Question32().findSubstring("sheateateseatea", new String[]{"sea","tea","ate"});
        System.out.println(result);
    }
}
