package LinkedList;

public class DoublyLinkedList {
    public static class ListNode{
        int value;
        ListNode prev,next;
        ListNode(int value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public static ListNode create(int[] arr){
        if (arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp=head;
        for(int i=1; i<arr.length ; i++){
            temp.next = new ListNode(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        System.out.print("Head->");
        while (temp !=null){
            System.out.print(temp.value + "<=>");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void reverseDisplay(ListNode head){
        ListNode temp = head;
        System.out.print("Head->");
        while (temp.next != null){
            temp = temp.next;
        }
        while (temp !=null){
            System.out.print(temp.value + "<=>");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    /**
     * Inserting in DoublyLinkedList
     * 1. Inserting at the first position
     * 2. Inserting at the given index
     */
    public static ListNode insert(ListNode head , ListNode node ,int index){
        if ((head == null && index != 1) || index <1){
            System.out.println("Index out of bound");
            return head;
        }
        else if (index == 1){
            if (head != null) {
                node.next = head;
                head.prev = node;
            }
            head = node;
        }else {
            ListNode temp = head;
            for (int i=1 ; i<index-1 && temp != null ; i++){
                temp = temp.next;
            }
            if (temp==null){
                System.out.println("Index out of bound");
            }else {
                node.next = temp.next;
                temp.next = node;
                node.prev = temp;
                node.next.prev=node;
            }
        }
        return head;
    }

    public  static ListNode delete(ListNode head, int index){
        ListNode temp;
        if (head == null || index < 1){
            System.out.println("Index out of bound");
            return  head;
        }else if (index ==1){
            temp = head;
            head = head.next;
            if(temp.next != null){
                temp.next.prev=null;
                temp.next = null;
            }
        }else{
            temp = head;
            for (int i=1; i< index-1 && temp!=null ;i++){
                temp = temp.next;
            }
            if (temp == null || temp.next == null){
                System.out.println("Index out of bound");
            }else {
                temp.next =  temp.next.next;
                if (temp.next !=null) {
                    temp.next.prev=temp;
                }
            }
        }
        temp=null;
        return head;
    }

    /**
     * Reversing DoublyLinkedList is same as rotating backward in a queue.
     */
    public static ListNode reverse(ListNode head){
        ListNode temp = head;
        while (temp != null){
            temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            if (temp != null){
                head = temp;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode doublyLinkedList = create(arr);
        display(doublyLinkedList);
        display(insert(doublyLinkedList , new ListNode(10),5));
//        ListNode deleteInDoublyList = delete(doublyLinkedList,10);
//        display(deleteInDoublyList);
//        reverseDisplay(deleteInDoublyList);
//        ListNode reversed = reverse(doublyLinkedList);
//        display(reversed);
//        reverseDisplay(reversed);
    }
}
