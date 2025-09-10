/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode nextOfMiddle = mid.next;
        mid.next = null;


        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        return mergeTwoLinkedList(left, right);
    }

    public ListNode middleNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLinkedList(ListNode a, ListNode b){

        if (a == null) return b;
        if (b == null) return a;

        ListNode result;
        if (a.val <= b.val) {
            result = a;
            result.next = mergeTwoLinkedList(a.next, b);
        } else {
            result = b;
            result.next = mergeTwoLinkedList(a, b.next);
        }
        return result;
    }

}