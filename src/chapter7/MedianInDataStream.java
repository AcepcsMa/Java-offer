package chapter7;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class MedianInDataStream {
	public PriorityQueue<Integer> minHeap;
	public PriorityQueue<Integer> maxHeap;

	public MedianInDataStream() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}

	/**
	 * 利用两个堆(优先队列)实现动态的中位数查找
	 * @param num 待插入的数字
	 */
	public void put(int num) {
		if(minHeap.isEmpty() && maxHeap.isEmpty()) {
			minHeap.add(num);
		} else if(minHeap.size() == maxHeap.size()) {
			if(num > minHeap.peek()) {
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else if(minHeap.size() > maxHeap.size()) {
			if(num > minHeap.peek()) {
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if(num < maxHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}

	/**
	 * 获取中位数
	 * @return 中位数
	 */
	public double getMedian() {
		if(minHeap.isEmpty() && maxHeap.isEmpty()) {
			return 0.0;
		}
		if(minHeap.size() == maxHeap.size()) {
			return (double)(minHeap.peek() + maxHeap.peek()) / 2.0;
		}
		if(minHeap.size() > maxHeap.size()) {
			return (double)minHeap.peek();
		} else {
			return (double)maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianInDataStream median = new MedianInDataStream();
		median.put(1);
		System.out.println(median.getMedian());
		median.put(2);
		System.out.println(median.getMedian());
		median.put(3);
		System.out.println(median.getMedian());
	}
}
