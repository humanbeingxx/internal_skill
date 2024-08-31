package priv.cxs.classic150;

import java.util.List;

public class Question140 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] pre = new int[triangle.size()];
        int[] next = new int[triangle.size()];
        pre[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            next[0] = pre[0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                next[j] = Math.min(pre[j], pre[j - 1]) + triangle.get(i).get(j);
            }
            next[i] = pre[i - 1] + triangle.get(i).get(i);
            int[] temp = pre;
            pre = next;
            next = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int num : pre) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Question140().minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
    }
}
