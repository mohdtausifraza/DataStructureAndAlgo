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


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode doublyLinkedList = create(arr);
        display(doublyLinkedList);
    }
}
