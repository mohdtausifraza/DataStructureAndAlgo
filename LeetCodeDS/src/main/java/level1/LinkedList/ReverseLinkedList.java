package level1.LinkedList;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
 *
 */
public class ReverseLinkedList {
    /**
     * Reversing the linked list by reversing the elements
     * Approach :   Copy the LinkedList in the ArrayList,
     *              Copy back the elements from ArrayList last index to the LinkedList first index.
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode ptr=head;
        while(ptr != null){
            list.add(ptr.val);
            ptr = ptr.next;
        }
        ptr = head;
        for(int i=list.size()-1 ; ptr != null ; ptr=ptr.next, i--){
            ptr.val = list.get(i);
        }
        return head;
    }

    /**
     * Reversing the reference.
     * Approach : Take three pointer and slide all three
     * Make middle pointer next point to first pointer node.
     */
    public ListNode reverseListThreePointer(ListNode head) {
        ListNode r=null,q=null,ptr=head;
        while(ptr != null){
            r=q;
            q=ptr;
            ptr=ptr.next;
            q.next=r;
        }
        head = q;
        return head;
    }
}
