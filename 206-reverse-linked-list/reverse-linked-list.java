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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode previous = head;
        ListNode current = head.next;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = previous;

            // update
            previous = current;
            current = nextNode;
        }

        head.next = null;
        head= previous;

        return head;
    }
}