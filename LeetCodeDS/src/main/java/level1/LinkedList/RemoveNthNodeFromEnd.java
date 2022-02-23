/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 *  Example:
 *      Given linked list: 1->2->3->4->5, and n = 2.
 *      After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *  Approach :  Take two pointer and skip second pointer to nth node.
 *              Now move both pointer till second next point to null
 *              Make first pointer point to next.next element.
 */
package level1.LinkedList;
class RemoveNthNodeFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // Create a node before first node and make fasf and slow points its.
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode fast = dummyHead;
            ListNode slow = dummyHead;

            // Move fast to n+1 position
            for(int i=1 ; i<=n+1 ; i++){
                fast = fast.next;
            }

            // Move both fast and slow till fast pointes to null;
            while(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummyHead.next;

        }
    }
}
