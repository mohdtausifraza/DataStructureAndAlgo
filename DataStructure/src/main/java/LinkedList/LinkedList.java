package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LinkedList is a collection of Nodes where each nodes contains data and reference to next node.
 */
public class LinkedList {

    private static ListNode list=null;

    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value, ListNode next){
            this.value = value;
            this.next=next;
        }
    }

    public static ListNode create(int[] arr){
        int i=1;
        ListNode head = new ListNode(arr[0],null);
        ListNode temp = head;
        while(i < arr.length){
            ListNode listNode = new ListNode(arr[i],null);
            temp.next = listNode;
            temp = listNode;
            i++;
        }
        return head;
    }

    public static void display(ListNode node){
        while (node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void displayRecursively(ListNode node){
        if (node != null){
            System.out.print(node.value + "->");
            displayRecursively(node.next);
        }else{
            System.out.println("null");
        }
    }

    public static int length(ListNode node){
        int count =0;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public static int sumOfAllElements(ListNode node){
        int sum=0;
        while(node != null){
            sum += node.value;
            node = node.next;
        }
        return sum;
    }

    public static int findMax(ListNode node){
        int max = Integer.MIN_VALUE;
        while(node != null){
            if (node.value > max){
                max = node.value;
            }
            node = node.next;
        }
        return max;
    }

    public static ListNode search(ListNode node , int key){
        while(node != null){
            if (key == node.value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static ListNode moveToHead(ListNode head , int key){
        ListNode p=head,q=null;
        if (key == head.value){
            return head;
        }
        while (p != null){
            if(key == p.value){
                q.next = p.next;
                p.next = head;
                head = p ;
                return head;
            }
            q = p;
            p = p.next;
        }
        return head;
    }

    public static ListNode insertBeforeFirst(ListNode head , ListNode node){
        node.next = head ;
        head = node;
        return head;
    }

    public static ListNode insertAfterPos(ListNode head , ListNode node , int pos){
        if (pos < 0 || pos > length(head)){
            System.out.println("Position is out of range : No insertion");
            return head;
        }
        else if (pos == 0){
            return insertBeforeFirst(head , node);
        }else{
            ListNode p = head;
            int i;
            for (i=1 ; i<pos ; i++){
                p = p.next;
            }
            node.next = p.next;
            p.next = node ;
            return head;
        }
    }

    /**
     * If you always want to insert at last, then maintain a pointer at last.
     */
    private static ListNode last;
    public  static ListNode insertAtLast(ListNode list , ListNode node){
        if (list == null){
            list = node;
        }else{
            last.next = node;
        }
        last = node;
        return list;
    }

    /**
     * Take only one pointer;
     */
    public static ListNode insertIntoSortedLinkedList(ListNode list , ListNode node){
        ListNode ptr=list;
        if (list == null || node.value < list.value){
            node.next = list;
            list = node ;
            return list;
        }
        while (ptr.next != null && ptr.next.value < node.value){
            ptr = ptr.next;
        }
        node.next = ptr.next;
        ptr.next = node ;
        return list;
    }

    public static ListNode deleteNode(int pos){
        if (list == null || pos < 1){
            System.out.println("No node found at the given position");
            return null;
        }else if(pos == 1){
            ListNode deletedNode=list;
            list = list.next;
            return deletedNode;
        }
        ListNode ptr = list,deletedNode=null;
        for (int i=1 ; i<pos-1 && ptr!=null ; i++){
            ptr = ptr.next;
        }
        if (ptr == null || ptr.next == null){
            System.out.println("No node found at the given position");
        }else{
            deletedNode=ptr.next;
            ptr.next = ptr.next.next;
        }
        return deletedNode;
    }

    public static boolean isSortedLinkedList(){
        if (list == null || list.next == null){
            return true;
        }
        ListNode ptr = list;
        while (ptr.next != null){
            if(ptr.value > ptr.next.value){
                return false;
            }
            ptr = ptr.next;
        }
        return true;
    }

    public static void removeDuplicateFromSortedLinkedList(){
        int noOfNodesDeleted=0;
        if (list == null || list.next == null){
            return;
        }
        ListNode left = list, right=list.next;
        while (right != null){
            if (left.value == right.value){
                left.next = right.next;
            }else{
                left = left.next;
            }
            right=right.next;
        }
    }

    /**
     * Reversing the linked list by reversing the elements
     * Approach :   Copy the LinkedList in the ArrayList,
     *              Copy back the elements from ArrayList last index to the LinkedList first index.
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode ptr=head;
        while(ptr != null){
            list.add(ptr.value);
            ptr = ptr.next;
        }
        ptr = head;
        for(int i=list.size()-1 ; ptr != null ; ptr=ptr.next, i--){
            ptr.value = list.get(i);
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

    /**
     * Concatenating LinkedList [Adding One LinkedList at the end of another LinkedList]
     * Approach :   Traverse in First LinkedList till last element
     *              Make first LinkedList last node next point to the second LinkedList first node
     */
    public static ListNode concat(ListNode first, ListNode second){
        ListNode ptr = first;
        while (ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = second;
        return first;
    }

    /**
     * Merge Two LinkedList
     * Merging is a process of combining two sorted List into a single Sorted List
     *
     *  Approach :  Take two pointer first and last,
     *              Make them point to the smallest node of both the list and detach that node from the list.
     *              Traverse in the List till any of the pointer l1 or l2 becomes null
     *                  Compare both the list and get the smallest element and add them to the node pointed by last pointer.
     *              Add the remaining node of any of the list to the last.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }
        ListNode first=null,last=null;
        if(l1.value < l2.value){
            first = last = l1;
            l1 = l1.next;
            first.next = null;
        }else{
            first = last = l2;
            l2 = l2.next;
            first.next = null;
        }
        while(l1 !=null && l2 !=null){
            if(l1.value < l2.value){
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

    /**
     * Approach :   Take two pointer slow and fast.
     *              Move Slow pointer with one step and fast pointer 2 step.
     *              If both meets then there is a loop in the Linked list.
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

    /**
     * Finding middle element of a LinkedList
     * Approach : Take two pointer. Move first pointer one step and second pointer two step.
     */
    public static int findMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if (fast !=null) {
                slow = slow.next;
            }
        }
        return slow.value;
    }

    public static ListNode intersectTwoLinkedList(ListNode head1, ListNode head2, int index){
        ListNode temp1=head1, temp2=head2;
        for (int i=0 ; i<index;i++){
            temp1 = temp1.next;
        }
        while (temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = temp1;
        list = head1;
        return head2;
    }

    /**
     * Find point of intersection of two linked list as created above
     * Approach :   Traverse in both the linked list and push the address in two different stack;
     *              Pop from both stack and compare till both differ.
     *              The address before that is the intersection point
     */
    public static ListNode findIntersectionPointOfTwoLinkedList(ListNode head1, ListNode head2){
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        while (head1 != null){
            stack1.push(head1.next);
            head1 = head1.next;
        }
        while (head2 != null){
            stack2.push(head2.next);
            head2 = head2.next;
        }
        ListNode intersectingNode = null;
        while (!stack1.empty() || !stack2.empty()){
            ListNode n1=stack1.pop(),n2=stack2.pop();
            if (n1 != n2) {
                return intersectingNode;
            }
            intersectingNode = n1;
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        list = create(arr);
        display(list);
        int[] arr2 = {11,22,33,44};
        ListNode list2 = create(arr2);
//        display(list2);
//        displayRecursively(list);
//        System.out.println(length(list));
//        System.out.println(sumOfAllElements(list));
//        System.out.println(findMax(list));
//        System.out.println(search(list,9));
//        list = moveToHead(list,4);
//        display(list);
//        list = insertBeforeFirst(list , new ListNode(0,null));
//        display(list);
//        list = insertAfterPos(list , new ListNode(-1,null),5);
//        display(list);
//        ListNode insertAtLast = insertAtLast(null , new ListNode(11,null));
//        insertAtLast = insertAtLast(insertAtLast , new ListNode(22,null));
//        display(insertAtLast);
//        int[] arr3 = {1,3,4,5,6,7,8,9};
//        ListNode sortedList = create(arr3);
//        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(0,null));
//        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(2,null));
//        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(22,null));
//        display(sortedList);
//        System.out.println(deleteNode(2).value);
//        display(list);
//        System.out.println(isSortedLinkedList());
//        removeDuplicateFromSortedLinkedList();
//        display(list);
//        ListNode concatenatedList = concat(list,list2);
//        display(concatenatedList);
//        ListNode mergedList = mergeTwoLists(list,list2);
//        display(mergedList);
//        System.out.print(findMid(list));
        ListNode head2 = intersectTwoLinkedList(list,list2,9);
        display(list);
        display(head2);
        ListNode intersectingNode = findIntersectionPointOfTwoLinkedList(list,list2);
        System.out.println(intersectingNode.value);
    }
}
