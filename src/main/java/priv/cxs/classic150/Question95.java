package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Question95 {

    List<Character> elements = new ArrayList<>();

    {
        elements.add('A');
        elements.add('C');
        elements.add('G');
        elements.add('T');
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Map<String, Integer> bankPath = buildBankMap(endGene, bankSet);
        int min = Integer.MAX_VALUE;
        if (bankPath.containsKey(startGene)) {
            min = bankPath.get(startGene);
        }
        List<String> reach = reach(startGene, bankSet);
        for (String s : reach) {
            if (bankPath.containsKey(s)) {
                min = Math.min(min, bankPath.get(s) + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private Map<String, Integer> buildBankMap(String endGene, Set<String> bank) {
        Map<String, Integer> bankPath = new HashMap<>();
        Set<String> checked = new HashSet<>();
        bankPath.put(endGene, 0);
        checked.add(endGene);
        Queue<String> queue = new LinkedList<>();
        queue.add(endGene);
        int len = 1;
        while (!queue.isEmpty() && !bank.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> nexts = reach(poll, bank);
                for (String next : nexts) {
                    if (checked.contains(next)) {
                        continue;
                    }
                    bankPath.put(next, len);
                    queue.add(next);
                    checked.add(next);
                }
            }
            len++;
        }
        return bankPath;
    }

    private List<String> reach(String end, Set<String> bank) {
        List<String> result = new ArrayList<>();
        char[] chars = end.toCharArray();
        for (int i = 0; i < end.length(); i++) {
            char c = end.charAt(i);
            int index = elements.indexOf(c);
            for (int j = 0; j < elements.size(); j++) {
                if (j != index) {
                    chars[i] = elements.get(j);
                    String newString = new String(chars);
                    if (bank.contains(newString)) {
                        result.add(newString);
                    }
                }
            }
            chars[i] = c;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new Question95().minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"});
        System.out.println(result);
    }
}
