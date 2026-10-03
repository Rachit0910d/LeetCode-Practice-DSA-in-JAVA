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
    public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || head.next == null) {
      return head;
    }

    ListNode left = head;
    ListNode right = null;
    ListNode prevLeft = null;
    ListNode res = null;
    int size = k;

    while (true) {
      right = left;

      for (int i = 0; i < (size - 1); i++) {
        if(right == null) break;
        right = right.next;
      }

      if (right != null) {
        ListNode nl = right.next;
        reverse(left, size);
        if (prevLeft != null) {
          prevLeft.next = right;
        }
        prevLeft = left;
        if (res == null) {
          res = right;
        }

        left = nl;
      } else {
        if (prevLeft != null) {
          prevLeft.next = left;

        }

        if (res == null) {
          res = left;
        }
        break;

      }
    }
    return res;

  }

  private void reverse(ListNode head, int size) {
    ListNode curr = head;
    ListNode prev = null;

    while (size-- != 0) {
      ListNode nex = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nex;
    }
  }
}