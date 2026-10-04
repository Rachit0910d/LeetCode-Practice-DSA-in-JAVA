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
    public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode left = head;
    ListNode right = head;

    ListNode temp = head;
    int count = 0;

    while (temp != null) {
      temp = temp.next;
      count++;
    }

    k = k % count;

    if (k == 0) {
      return head;
    }

    for (int i = 0; i < k; i++) {
      right = right.next;
    }
    while (right.next != null) {
      right = right.next;
      left = left.next;
    }

    ListNode newHead = left.next;
    right.next = head;
    left.next = null;

    return newHead;
  }
}