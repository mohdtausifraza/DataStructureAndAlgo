package level1.LinkedList;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
 */
public class CycleInLinkedList {
    /**
     * Approach :   Take two pointer slow and fast.
     *              Move Slow pointer with one step and fast pointer 2 step.
     *              If both meets then there is a loop in the Linked list.
     * TimeComplexity   : O(n)
     * SpaceComplexity  : O(1)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        fast = fast.next;
        while(fast.next!=null && fast.next.next!=null){
            if(fast==slow){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}
