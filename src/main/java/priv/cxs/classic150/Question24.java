package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.List;

public class Question24 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length;
        List<String> text = new ArrayList<>();
        int width = words[0].length(), wordCount = 1;
        StringBuilder stringBuilder = new StringBuilder(words[0]);
        for (int i = 1; i < length; i++) {
            String word = words[i];
            if (width + word.length() + 1 <= maxWidth) {
                width += word.length() + 1;
                stringBuilder.append(' ').append(word);
                wordCount++;
            } else {
                text.add(adjust(stringBuilder, wordCount, maxWidth));
                stringBuilder.setLength(0);
                stringBuilder.append(word);
                wordCount = 1;
                width = word.length();
            }
        }
        if (stringBuilder.length() > 0) {
            int len = stringBuilder.length();
            for (int i = 0; i < maxWidth - len; i++) {
                stringBuilder.append(' ');
            }
            text.add(stringBuilder.toString());
        }
        return text;
    }

    private String adjust(StringBuilder stringBuilder, int wordCount, int maxWidth) {
        int addBlank = maxWidth - stringBuilder.length();
        if (wordCount == 1) {
            for (int i = 0; i < addBlank; i++) {
                stringBuilder.append(' ');
            }
            return stringBuilder.toString();
        } else {
            StringBuilder adjusted = new StringBuilder(maxWidth);
            int[] eachAdd = new int[wordCount - 1];
            int index = 0;
            for (int i = 0; i < addBlank; i++) {
                eachAdd[index]++;
                index++;
                if (index == wordCount - 1) {
                    index = 0;
                }
            }
            index = 0;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) != ' ') {
                    adjusted.append(stringBuilder.charAt(i));
                } else {
                    adjusted.append(' ');
                    for (int j = 0; j < eachAdd[index]; j++) {
                        adjusted.append(' ');
                    }
                    index++;
                }
            }
            return adjusted.toString();
        }
    }

    public static void main(String[] args) {
        String[] strings = {
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        };
        System.out.println(new Question24().fullJustify(strings, 20));
    }
}