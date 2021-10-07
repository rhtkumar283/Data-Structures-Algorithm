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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length = 0;
        int carry = 0;
        int s = 0;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        while(l1 != null || l2 != null){
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;

            s = v1 + v2 + carry;
            temp.next = new ListNode(s % 10);
            temp = temp.next;

            carry = s / 10;
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return ans.next;
    }
}
