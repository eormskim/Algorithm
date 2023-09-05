package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(ListNode.of(1,2,4),ListNode.of(1,3,4))); //[1,1,2,3,4,4]
        System.out.println(mergeTwoLists(new ListNode(),new ListNode())); //[]
        System.out.println(mergeTwoLists(new ListNode(),new ListNode(0))); //[0]
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        //ListNode 정보를 배열에 넣기
        if(list1 != null){
            if(list1.next == null){
                arrayList.add(list1.val);
            }
            while (list1.next != null){
                arrayList.add(list1.val);
                list1 = list1.next;
                if(list1.next == null){
                    arrayList.add(list1.val);
                }
            }
        }

        if(list2 != null){
            if(list2.next == null){
                arrayList.add(list2.val);
            }
            while (list2.next != null){
                arrayList.add(list2.val);
                list2 = list2.next;
                if(list2.next == null){
                    arrayList.add(list2.val);
                }
            }
        }

        Collections.sort(arrayList); //정렬
        ListNode answer = new ListNode();
        answer.val = arrayList.get(0);
        for(int i = 1; i < arrayList.size(); i++){
            makeListNode(answer, arrayList.get(i));
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
