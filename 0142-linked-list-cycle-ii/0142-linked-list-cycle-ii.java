/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cnt = 0;

        if(head == null || head.next == null) return null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            cnt += 1;
            if(fast == slow){
                slow = head; //reset the node 
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}