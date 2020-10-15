package level1.LinkedList;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
 * Merging is a process of combining two sorted List into a single Sorted List
 */
public class MergeTwoLinkedList {
    /**
     *  Approach :  Take two pointer first and last,
     *              Make them point to the smallest node of both the list and detach that node from the list.
     *              Traverse in the List till any of the pointer l1 or l2 becomes null
     *                  Compare both the list and get the smallest element and add them to the node pointed by last pointer.
     *              Add the remaining node of any of the list to the last.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }
        ListNode first=null,last=null;
        if(l1.val < l2.val){
            first = last = l1;
            l1 = l1.next;
            first.next = null;
        }else{
            first = last = l2;
            l2 = l2.next;
            first.next = null;
        }
        while(l1 !=null && l2 !=null){
            if(l1.val < l2.val){
                last.next = l1;
                last = l1;
                l1 = l1.next;
                last.next = null;
            }else{
                last.next = l2;
                last = l2;
                l2 = l2.next;
                last.next = null;
            }
        }
        if(l1 == null)
            last.next = l2;
        else
            last.next = l1;
        return first;
    }
}
