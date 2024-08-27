package priv.cxs.classic150;

public class Question130 {

    public int[] plusOne(int[] digits) {
        int adv = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                adv = 0;
                break;
            }
        }
        if (adv == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }
    }
}
