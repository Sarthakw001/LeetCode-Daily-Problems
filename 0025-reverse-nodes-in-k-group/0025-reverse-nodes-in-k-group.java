class Solution {

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode curr = head;
        ListNode tempEnd = null;

        while (curr != null) {

            // Find the exclusive end of a complete group
            ListNode end = curr;

            for (int i = 0; i < k; i++) {
                if (end == null) {
                    return head;
                }
                end = end.next;
            }

            // Original group head becomes the new group's tail
            ListNode groupTail = curr;

            // Reverse nodes from curr up to, but excluding, end
            ListNode newGroupHead = reverse(curr, end);

            // Connect the previous group to this group's new head
            if (tempEnd == null) {
                head = newGroupHead;
            } else {
                tempEnd.next = newGroupHead;
            }

            // Connect this group's tail to the next group
            groupTail.next = end;

            // Save the tail for the next iteration
            tempEnd = groupTail;

            // Process the next group
            curr = end;
        }

        return head;
    }
}