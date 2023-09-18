package Leetcode;

import java.util.PriorityQueue;
/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */

public class Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        Merge_k_Sorted_Lists solution = new Merge_k_Sorted_Lists();

        // Create example sorted lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Merge the sorted lists
        ListNode[] lists = { list1, list2, list3 };
        ListNode merged = solution.mergeKLists(lists);

        // Print the merged list
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
        System.out.println("null");
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue (min heap) to store the nodes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to the min heap
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.offer(list.val);
                list = list.next;
            }
        }

        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Reconstruct the merged list
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }

        return dummy.next;
    }
}
