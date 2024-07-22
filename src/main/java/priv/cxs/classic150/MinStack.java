package priv.cxs.classic150;

import java.util.Stack;

public class MinStack {

    Stack<Integer> data;
    Stack<Integer> history;

    public MinStack() {
        data = new Stack<>();
        history = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (history.isEmpty()) {
            history.push(val);
        } else {
            if (history.peek() < val) {
                history.push(history.peek());
            } else {
                history.push(val);
            }
        }
    }

    public void pop() {
        data.pop();
        history.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return history.peek();
    }
}
