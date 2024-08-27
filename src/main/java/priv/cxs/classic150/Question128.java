package priv.cxs.classic150;

public class Question128 {

    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left < right) {
            count++;
            left >>= 1;
            right >>= 1;
        }
        if (count == 0) {
            return 0;
        }
        return right << count;
    }
}
