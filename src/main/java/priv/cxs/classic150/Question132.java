package priv.cxs.classic150;

public class Question132 {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mul = mid * (long)mid;
            if (mul == x) {
                return mid;
            } else if (mul < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Question132().mySqrt(2147395599));
    }
}
