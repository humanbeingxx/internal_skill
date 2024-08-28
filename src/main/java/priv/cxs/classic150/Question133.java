package priv.cxs.classic150;

public class Question133 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double pow = myPow(x, n / 2);
        if (n % 2 == 1) {
            return pow * pow * x;
        } else if (n % 2 == -1) {
            return pow * pow / x;
        } else {
            return pow * pow;
        }
    }

    public static void main(String[] args) {
        new Question133().myPow(0.00001, 2147483647);
    }
}
