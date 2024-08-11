package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question100 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            temp.add(0);
        }
        rec(n, k, 0, temp, result);
        return result;
    }

    private void rec(int n, int k, int index, List<Integer> ints, List<List<Integer>> result) {
        if (index == k) {
            result.add(new ArrayList<>(ints));
            return;
        }
        int num = 1;
        if (index > 0) {
            num = ints.get(index - 1) + 1;
        }
        for (; num <= n; num++) {
            ints.set(index, num);
            rec(n, k, index + 1, ints, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question100().combine(4, 2));
    }
}
