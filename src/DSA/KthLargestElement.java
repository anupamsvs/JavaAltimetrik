package DSA;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3,5,1,8,10,16};
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }

    private static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : arr) {
            minHeap.add(n);
            System.out.println("State after nth addition = " + minHeap);
            if(minHeap.size() > k) {
                minHeap.poll();
                System.out.println("State After polling = " + minHeap);
            }
        }
        System.out.println("Final state of PQ = " + minHeap);
        return minHeap.peek();
    }
}
