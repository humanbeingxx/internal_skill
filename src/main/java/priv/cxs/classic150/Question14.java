package priv.cxs.classic150;

public class Question14 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        boolean complete;
        while (true) {
            complete = true;
            int curGas = gas[start];
            for (int i = 0; i < gas.length; i++) {
                int cur = (start + i) % gas.length;
                int next = (start + i + 1) % gas.length;
                if (curGas < cost[cur]) {
                    if (start >= next) {
                        return -1;
                    }
                    start = next;
                    complete = false;
                    break;
                } else {
                    curGas += gas[next] - cost[cur];
                }
            }
            if (complete) {
                return start;
            }
        }
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int result = new Question14().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
