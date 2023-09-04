package Leetcode;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode l1 = ListNode.of(1,2,3,4,5);
        System.out.println(removeNthFromEnd(l1,2)); // [1,2,3,5]
        System.out.println(removeNthFromEnd(ListNode.of(1),1)); // []
        System.out.println(removeNthFromEnd(ListNode.of(1,2),1)); // [1]
        System.out.println(removeNthFromEnd(ListNode.of(3,7,9,3,5,8,0),1)); // [3,7,9,3,5,8]
        System.out.println(removeNthFromEnd(ListNode.of(9,0,3,8,7,3,8,6,3,1),10)); // [0,3,8,7,3,8,6,3,1]
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){ //첫번째 헤드만 있을경우
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (head.next != null){
            arrayList.add(head.val);
            head = head.next;
            if(head.next == null){
                arrayList.add(head.val);
            }
        }
        Collections.reverse(arrayList); //뒤에서부터 색인하기 위해 리스트 반대로 돌리기
        arrayList.remove(n-1); // 0번째부터 시작하도록 -1 처리
        Collections.reverse(arrayList); //제거 후 원상복구

        ListNode answer = new ListNode();
        for(int i=0; i<arrayList.size(); i++){
            if(i == 0){
                answer.val = (int)arrayList.get(i);
            }else{
                makeListNode(answer, (int)arrayList.get(i));
            }
        }

        return answer;
    }

    //ListNode.next 에 값을 넣기 위한 메소드
    public static ListNode makeListNode(ListNode node, int value){
        if(node.next == null){
            node.next = new ListNode(value);
            return node;
        }else{
            node = makeListNode(node.next, value);
        }
        return node;
    }
}
