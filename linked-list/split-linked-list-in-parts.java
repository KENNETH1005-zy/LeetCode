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
    public ListNode[] splitListToParts(ListNode head, int k) {
        //count the total length
        //divid into k parts
        ListNode[] result = new ListNode[k];
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        ListNode curr = head;
        ListNode prev = head;

        int base = count / k;
        int remaining = count % k;

        for (int i = 0; i<k; i++) {
            result[i] = curr;
            int addOn = remaining == 0? 0: 1;
            if (remaining != 0) remaining -= 1;

            for (int j = 0; j<base + addOn; j++) {
                prev = curr;
                if (curr != null) curr = curr.next;
            }
            if (prev != null) prev.next = null;
        }
        return result;
    }
}