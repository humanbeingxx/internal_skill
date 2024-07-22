package priv.cxs.classic150;

import java.util.Stack;

public class Question51 {

    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}
