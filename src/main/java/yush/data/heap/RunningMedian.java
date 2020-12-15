package yush.data.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

	class MedianOfIntegerStream {

	    private Queue<Integer> minHeap, maxHeap;

	    MedianOfIntegerStream() {
	        minHeap = new PriorityQueue<>();
	        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	    }

	    void add(int num) {
	        if (minHeap.size() == maxHeap.size()) {
	            maxHeap.offer(num);
	            minHeap.offer(maxHeap.poll());
	        } else {
	            minHeap.offer(num);
	            maxHeap.offer(minHeap.poll());
	        }
	    }

	    double getMedian() {
	        if (minHeap.size() > maxHeap.size()) {
	            return minHeap.peek();
	        } else {
	            return (minHeap.peek() + maxHeap.peek()) / 2.0;
	        }
	    }
	}
}
