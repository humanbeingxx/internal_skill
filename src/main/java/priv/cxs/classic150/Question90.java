package priv.cxs.classic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Question90 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> processed = new HashMap<>();
        processed.put(node, new Node(node.val));
        Queue<Node> processing = new LinkedList<>();
        processing.add(node);
        while (!processing.isEmpty()) {
            Node poll = processing.poll();
            Node copy = processed.get(poll);
            copy.neighbors = new ArrayList<>();
            if (poll.neighbors != null && !poll.neighbors.isEmpty()) {
                for (Node neighbor : poll.neighbors) {
                    Node copyNeighbor = processed.get(neighbor);
                    if (copyNeighbor == null) {
                        copyNeighbor = new Node(neighbor.val);
                        processed.put(neighbor, copyNeighbor);
                        copy.neighbors.add(copyNeighbor);
                        processing.add(neighbor);
                    } else {
                        copy.neighbors.add(copyNeighbor);
                    }
                }
            }
        }
        return processed.get(node);
    }
}
