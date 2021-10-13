package LinkedList;

/**
 * A Linked List in which the last node points to the head node is called a circular linked list,
 */
public class CircularLinkedList {
    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Creating Circular Linked List from Array
     */
    public static ListNode create(int[] arr){
        if (arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i=1 ; i< arr.length ; i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        temp.next = head;
        return head;
    }

    /**
     * Displaying Circular Linked List
     */
    public static void display(ListNode head){
        if (head == null){
            System.out.println("Head->Head");
            return;
        }
        System.out.print("Head->");
        ListNode temp = head;
        do{
            System.out.print(temp.value + "->");
            temp = temp.next;
        }while(temp != head);
        System.out.println("Head");
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        ListNode circularLinkedList = create(arr);
        display(circularLinkedList);

//        display(insert(circularLinkedList, new ListNode(0),5));
//        display(delete(circularLinkedList,5));
    }
}
