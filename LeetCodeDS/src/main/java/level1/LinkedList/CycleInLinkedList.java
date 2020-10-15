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
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast=head.next;
        while(fast !=null){
            if(fast == head)
                return true;
            head = head.next;
            fast = fast.next;
            fast = fast !=null ? fast.next : null;
        }
        return false;
    }
}
