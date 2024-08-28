package priv.cxs.classic150;

import java.util.HashMap;
import java.util.Map;

public class Question134 {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                int x,y;
                if (points[i][1] > points[j][1]) {
                    x = points[i][0] - points[j][0];
                    y = points[i][1] - points[j][1];
                } else {
                    x = points[j][0] - points[i][0];
                    y = points[j][1] - points[i][1];
                }
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    int gcd = gcd(Math.abs(x), Math.abs(y));
                    x /= gcd;
                    y /= gcd;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res = Math.max(res, entry.getValue() + 1);
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
