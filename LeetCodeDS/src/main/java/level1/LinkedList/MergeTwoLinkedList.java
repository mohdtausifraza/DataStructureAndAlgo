package level1.LinkedList;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
 * Merging is a process of combining two sorted List into a single Sorted List
 */
public class MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode currentNode = newList;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                currentNode.next=l1;
                l1=l1.next;
            }else{
                currentNode.next=l2;
                l2=l2.next;
            }
            currentNode = currentNode.next;
        }
        if(l1==null){
            currentNode.next=l2;
        }if(l2==null){
            currentNode.next=l1;
        }
        return newList.next;
    }

    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
