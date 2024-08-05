package priv.cxs.classic150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question91 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> nodes = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            if (!nodes.containsKey(start)) {
                nodes.put(start, new HashMap<>());
            }
            nodes.get(start).put(end, values[i]);
            if (!nodes.containsKey(end)) {
                nodes.put(end, new HashMap<>());
            }
            nodes.get(end).put(start, 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = calc(nodes, start, end, 1, new HashSet<>());
            if (result[i] == -1) {
                result[i] = calc(nodes, end, start, 1, new HashSet<>());
            }
        }
        return result;
    }

    private double calc(Map<String, Map<String, Double>> nodes, String start, String end, double cur, Set<String> processed) {
        Map<String, Double> nexts = nodes.get(start);
        if (nexts == null || nexts.size() == 0 || processed.contains(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return cur;
        }
        processed.add(start);
        for (Map.Entry<String, Double> stringDoubleEntry : nexts.entrySet()) {
            String next = stringDoubleEntry.getKey();
            Double val = stringDoubleEntry.getValue();
            if (next.equals(end)) {
                return cur * val;
            }
            double nextResult = calc(nodes, next, end, cur * val, processed);
            if (nextResult != -1) {
                return nextResult;
            }
        }
        return -1;
    }
}
