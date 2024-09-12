package Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;


// Ascending order for priority queue is minHeap ex. (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
// Descending order for priority queue is maxHeap ex. (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])

// Comparator order depends on input for (a, b)
// Ascending ex. (a,b) -> a[1].compareTo(b[1])
// Descending ex. (a,b) -> b[1].compareTo(a[1])

// If ascending order and specific int value
// Comparator.comparingInt(node -> node.val)

public class KClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) ->(b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.toArray(new int[0][0]);
    }

    public static void main(String args[]) {
        int[][] points = {{1,3},{-2,2}};
        System.out.println((Arrays.deepToString(kClosest(points, 1))));
    }
}
