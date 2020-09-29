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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head, second=head;
        if(head.next == null){
            return null;
        }
        while(second.next != null){
            if(n > 0){
                second=second.next;
                n--;
            }else{
                first = first.next;
                second = second.next;
            }
        }
        if(n==1){
            head = head.next;
        }else{
            first.next = first.next.next;
        }
        return head;
    }
}
