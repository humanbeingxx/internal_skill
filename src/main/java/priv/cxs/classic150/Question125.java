package priv.cxs.classic150;

public class Question125 {
    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & flag) == flag) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }
}
