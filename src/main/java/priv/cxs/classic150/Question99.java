package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question99 {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, List<Character>> mapping = new HashMap<>();
        mapping.put('2', Arrays.asList('a', 'b', 'c'));
        mapping.put('3', Arrays.asList('d', 'e', 'f'));
        mapping.put('4', Arrays.asList('g', 'h', 'i'));
        mapping.put('5', Arrays.asList('j', 'k', 'l'));
        mapping.put('6', Arrays.asList('m', 'n', 'o'));
        mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
        mapping.put('8', Arrays.asList('t', 'u', 'v'));
        mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        rec(digits, 0, new char[digits.length()], mapping, result);
        return result;
    }

    private void rec(String digits, int index, char[] chars, Map<Character, List<Character>> mapping, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(chars));
            return;
        }
        for (Character c : mapping.get(digits.charAt(index))) {
            chars[index] = c;
            rec(digits, index + 1, chars, mapping, result);
        }
    }
}
