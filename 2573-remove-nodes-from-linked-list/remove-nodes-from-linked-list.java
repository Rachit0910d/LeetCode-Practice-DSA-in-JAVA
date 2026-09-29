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
    public ListNode removeNodes(ListNode head) {
    LinkedList<Integer> list = new LinkedList<>();
    Stack<Integer> st = new Stack<>();


    for (ListNode temp = head; temp != null; temp = temp.next) {
      while(!st.isEmpty() && st.peek() < temp.val){
        st.pop();
      }
      st.push(temp.val);
    }

    ListNode newHead = null;

    while(!st.isEmpty()){
      ListNode node = new ListNode(st.pop());
      node.next = newHead;
      newHead = node;
    }

    return newHead;

  }
}