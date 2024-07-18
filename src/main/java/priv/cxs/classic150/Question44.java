package priv.cxs.classic150;

public class Question44 {

    public boolean isHappy(int n) {
        int fast = next(n), slow = n;
        while (fast != slow && fast != 1) {
            fast = next(next(fast));
            slow = next(slow);
        }
        return fast == 1;
    }

    private int next(int n) {
        int next = 0;
        while (n > 0) {
            int mod = (n % 10);
            next += mod * mod;
            n /= 10;
        }
        return next;
    }
}
