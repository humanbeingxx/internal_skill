package priv.cxs.classic150;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> littler;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        littler = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        larger = new PriorityQueue<>(Integer::compare);
    }

    public void addNum(int num) {
        if (littler.isEmpty() || num <= littler.peek()) {
            littler.offer(num);
            if (littler.size() > larger.size() + 1) {
                larger.offer(littler.poll());
            }
        } else {
            larger.offer(num);
            if (larger.size() > littler.size()) {
                littler.offer(larger.poll());
            }
        }
    }

    public double findMedian() {
        if (littler.size() > larger.size()) {
            return littler.peek();
        } else {
            return (littler.peek() + larger.peek()) / 2.0;
        }
    }
}
