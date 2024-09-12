package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;


// Revisit

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode result = new ListNode();
        ListNode walker = result;
        for(ListNode head: lists) {
            if(head == null) {
                continue;
            }
            pq.add(head);
            walker.next = head;
            ListNode curr = head.next;
            while (curr!=null) {
                pq.add(curr);
                curr = curr.next;
                walker = walker.next;
            }
        }
        walker = result;
        while (!pq.isEmpty()) {
            walker.next = pq.poll();
            walker = walker.next;
        }
        walker.next = null;
        return result.next;
    }

    public static ListNode mergeKLists_faster(ListNode[] lists) {
        if(lists.length==0 || lists==null){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode();
        ListNode walker = head;
        for(int i=0; i<lists.length; i++){
            if(lists[i]==null){
                continue;
            }
            walker.next = lists[i];
            walker = walker.next;
            pq.add(walker);
            while(walker.next!=null){
                walker = walker.next;
                pq.add(walker);
            }
        }
        walker = head;
        while(!pq.isEmpty()) {
            walker.next = pq.poll();
            walker=walker.next;
        }
        walker.next = null;
        return head.next;
    }

    public static void main(String args[]) {
        int[][] orglists = {{-2,-1,-1,-1}, {}};
        ListNode[] lists = new ListNode[orglists.length];
        for(int k=0; k<orglists.length; k++) {
            int[] list = orglists[k];
            if (list.length == 0) {
                lists[k] = null;
                break;
            }
            ListNode head = new ListNode(list[0]);
            ListNode curr = head;
            for (int i=1; i<list.length; i++) {
                curr.next = new ListNode(list[i]);
                curr = curr.next;
            }
            lists[k] = head;
        }

        ListNode node = mergeKLists_faster(lists);
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
