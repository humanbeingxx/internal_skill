package priv.cxs.classic150;

public class Question123 {


    public String addBinary(String a, String b) {
        boolean adv = false;
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1, indexB = b.length() - 1;
        while (indexA >= 0 && indexB >= 0) {
            char aChar = a.charAt(indexA);
            char bChar = b.charAt(indexB);
            if (aChar == '0' && bChar == '0') {
                if (adv) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                adv = false;
            } else if (aChar == '1' && bChar == '1') {
                if (adv) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                adv = true;
            } else {
                if (adv) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            indexA--;
            indexB--;
        }
        while (indexA >=0) {
            char aChar = a.charAt(indexA);
            if (aChar == '0') {
                if (adv) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                adv = false;
            } else {
                if (adv) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            indexA--;
        }
        while (indexB >= 0) {
            char bChar = b.charAt(indexB);
            if (bChar == '0') {
                if (adv) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
                adv = false;
            } else {
                if (adv) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            indexB--;
        }
        if (adv) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
