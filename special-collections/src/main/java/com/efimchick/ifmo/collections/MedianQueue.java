package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue extends PriorityQueue {
    PriorityQueue< Integer> minHeap;
    PriorityQueue< Integer> maxHeap;

    public MedianQueue() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    @Override
    public boolean offer(Object o) {
        int num = Integer.parseInt(o.toString());

        if (maxHeap.size() > 0 && num > minHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        handleBalance();
        return true;
    }
    private void handleBalance() {
        if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.remove());
        }
    }
    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }

    @Override
    public Object peek() {
        if (this.size() == 0) {
            return -1;
        } else if (minHeap.size() >= maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    @Override
    public Iterator iterator() {
        return super.iterator();
    }

    @Override
    public int size() {
        return minHeap.size() + maxHeap.size();
    }

    @Override
    public Object poll() {
        if (this.size() == 0) {
            return -1;
        } else if (minHeap.size() >= maxHeap.size()) {
            return minHeap.remove();
        } else {
            return maxHeap.remove();
        }
    }
}
