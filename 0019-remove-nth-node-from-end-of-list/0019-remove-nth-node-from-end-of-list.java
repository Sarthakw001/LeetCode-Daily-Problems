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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, end = head;
        while(n>0){
            n--;
            end=end.next;
        }

        ListNode prev = null;
        while(end!=null){
            end=end.next;
            prev=curr;
            curr=curr.next;
        }
        
        if(prev==null){
            return head.next;
        }
        prev.next = curr.next;
        return head;
    }
}