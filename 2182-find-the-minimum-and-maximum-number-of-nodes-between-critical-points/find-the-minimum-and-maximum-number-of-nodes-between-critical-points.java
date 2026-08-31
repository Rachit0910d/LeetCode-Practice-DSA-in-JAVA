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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minD = Integer.MAX_VALUE;
        int maxD = -1;

        int firstCP = -1;
        int prevCP = -1;

        int index = 1;

        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;

        while (third != null) {

            if (second.val < first.val && second.val < third.val) {
                if (firstCP == -1) {
                    firstCP = index;
                }

                if (prevCP != -1) {
                    minD = Math.min(minD, index - prevCP);
                }

                prevCP = index;
            }

            else if (second.val > first.val && second.val > third.val) {
                if (firstCP == -1) {
                    firstCP = index;
                }

                if (prevCP != -1) {
                    minD = Math.min(minD, index - prevCP);
                }

                prevCP = index;
            }

            first = second;
            second = third;
            third = third.next;
            index++;
        }

        if (firstCP == -1 || firstCP == prevCP) {
            return new int[] { -1, -1 };
        }

        maxD = prevCP - firstCP;

        return new int[] { minD, maxD };
    }

}