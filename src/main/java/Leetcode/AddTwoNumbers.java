package Leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        System.out.println(addTwoNumbers(l1,l2));
        l1 = ListNode.of(0);
        l2 = ListNode.of(0);
        System.out.println(addTwoNumbers(l1,l2));
        l1 = ListNode.of(9,9,9,9,9,9,9);
        l2 = ListNode.of(9,9,9,9);
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode rtnListNode = node;
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;

        boolean nextPlus = false;
        while (listNode1 != null || listNode2 != null){
            int sumNodeVal = 0;
            if(listNode1 != null){
                sumNodeVal += listNode1.val;
                listNode1 = listNode1.next;
            }
            if(listNode2 != null){
                sumNodeVal += listNode2.val;
                listNode2 = listNode2.next;
            }
            if(nextPlus){
                sumNodeVal += 1;
                nextPlus = false;
            }
            if(sumNodeVal > 9){
                sumNodeVal-=10;
                nextPlus = true;
            }
            if(sumNodeVal < 0){
                sumNodeVal = 0;
            }
            node.next = new ListNode(sumNodeVal);
            node = node.next;
        }
        if(nextPlus){
            node.next = new ListNode(1);
        }
        return rtnListNode.next;
    }

}
