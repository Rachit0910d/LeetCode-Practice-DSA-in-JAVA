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
   public ListNode reverseEvenLengthGroups(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode left = head;
    ListNode prevLeft = null;

    int size = 1;

    while (left != null) {

      ListNode right = left;

      for (int i = 1; i < size && right.next != null; i++) {
        right = right.next;
      }

      int actualSize = 1;
      ListNode temp = left;

      while (temp != right) {
        temp = temp.next;
        actualSize++;
      }

      ListNode nextGroup = right.next;

      if ((actualSize & 1) == 0) {

        ListNode newHead = reverse2(left, actualSize);

        if (prevLeft == null) {
          head = newHead;
        } else {
          prevLeft.next = newHead;
        }

        left.next = nextGroup;

        prevLeft = left;
        left = nextGroup;

      } else {

        prevLeft = right;
        left = nextGroup;
      }

      size++;
    }

    return head;
  }
  private ListNode reverse2(ListNode head, int size) {

    ListNode prev = null;
    ListNode curr = head;

    while (size-- > 0) {

      ListNode next = curr.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}