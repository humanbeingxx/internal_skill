package priv.cxs.classic150;

public class Question11 {

    public int hIndex(int[] citations) {
        int[] refCount = new int[1001];
        for (int i = 0; i < citations.length; i++) {
            refCount[citations[i]]++;
        }
        for (int i = refCount.length - 1; i >= 0; i--) {
            if (i > 0) {
                refCount[i - 1] += refCount[i];
            }
            if (refCount[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
