import java.util.*;

public class MedianStream {
    Scanner scanner;
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianStream() {
        this.scanner = new Scanner(System.in);
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
    }

    public void insert(int num) {
        if (maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        } else if (minHeap.size() == 0) {
            minHeap.add(num);
            return;
        }
        int maxHeapTop = maxHeap.peek();
        int minHeapTop = minHeap.peek();
        if (minHeapTop < num) {
            minHeap.add(num);
        } else if (maxHeapTop > num) {
            maxHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        if (maxHeap.size() > 1 + minHeap.size()) {
            int maxTop = maxHeap.poll();
            minHeap.add(maxTop);
        } else if (minHeap.size() > maxHeap.size()) {
            int minTop = minHeap.poll();
            maxHeap.add(minTop);
        }
    }

    public double getMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        int maxTop = maxHeap.peek();
        int minTop = minHeap.peek();
        return (maxTop + minTop) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println("Median Stream...");
        MedianStream medianStream = new MedianStream();
        while (true) {
            int number = medianStream.scanner.nextInt();
            medianStream.insert(number);
            double median = medianStream.getMedian();
            System.out.println("Median: " + median);
        }
    }

}
