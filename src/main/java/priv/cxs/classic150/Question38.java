package priv.cxs.classic150;

public class Question38 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rcount = count(ransomNote);
        int[] mcount = count(magazine);
        for (int i = 0; i < rcount.length; i++) {
            if (rcount[i] > mcount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
