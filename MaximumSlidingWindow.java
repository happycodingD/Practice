package Amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {

    // Time limit exceeded 37/50 passed
    public static int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        int i = 1;
        int j = k;
        while (j<nums.length) {
            result.add(pq.peek());
            pq.remove(nums[i-1]);
            pq.add(nums[j]);
            i++;
            j++;
        }
        result.add(pq.peek());
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] maxSlidingWindow_optimized (int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(!deque.isEmpty() && deque.peek()<=i-k) {
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1 && !deque.isEmpty()) {
                result.add(nums[deque.peek()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow_optimized(nums, 3)));
    }
}
