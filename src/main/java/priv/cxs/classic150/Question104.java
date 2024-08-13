package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question104 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        rec(n, 0, 0, 0, new char[n * 2], result);
        return result;
    }

    private void rec(int n, int leftCount, int rightCount, int index, char[] temp, List<String> result) {
        if (index == n * 2) {
            result.add(new String(temp));
            return;
        }
        if (leftCount < n) {
            temp[index] = '(';
            rec(n, leftCount + 1, rightCount, index + 1, temp, result);
        }
        if (rightCount < leftCount) {
            temp[index] = ')';
            rec(n, leftCount, rightCount + 1, index + 1, temp, result);
        }
    }
}
