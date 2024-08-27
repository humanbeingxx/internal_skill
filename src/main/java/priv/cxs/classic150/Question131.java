package priv.cxs.classic150;

public class Question131 {

    public int trailingZeroes(int n) {
        int count5 = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0 && num % 5 == 0) {
                count5++;
                num /= 5;
            }
        }
        return count5;
    }
}
