package LinkedList;

public class CircularDoublyLinkedList {
    public static class ListNode{
        int value;
        ListNode prev;
        ListNode next;
        ListNode(int value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public static ListNode create(int[] arr){
        if (arr.length < 1){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i=1 ; i < arr.length ; i++){
            temp.next = new ListNode(arr[i]);
            temp.next.prev = temp;
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;
        return  head;
    }

    public static  void display(ListNode head){
        if (head == null){
            System.out.println("Head->NULL");
            return;
        }
        ListNode temp = head;
        System.out.print("Head=>");
        do{
            System.out.print(temp.value + "<=>");
            temp = temp.next;
        }while (temp != head);
        System.out.println("Head");

    }

    public  static ListNode insert(ListNode head, ListNode node, int index){
        if (index < 1 || (head==null && index !=1)){
            System.out.println("Index out of bound");
        }else if (index == 1){
            if (head == null){
                head = node;
                node.next=head;
                node.prev=head;
            }else{
                ListNode temp = head.next;
                while(temp.next != head){
                    temp = temp.next;
                }
                node.next=head;
                node.prev= head.prev;
                temp.next = node;
                head = node;
            }
        }else {
            int flag =1;
            ListNode temp = head;
            for (int i=1 ; i < index-1; i++){
                temp = temp.next;
                if (temp == head){
                    flag =0;
                    break;
                }
            }
            if (flag ==0){
                System.out.println("Index out of bound");
            }else{
                node.next = temp.next;
                node.prev = temp;
                temp.next.prev = node;
                temp.next = node;
            }
            temp = null;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        ListNode circularDLL = create(arr);
        display(circularDLL);
        ListNode insert = insert(circularDLL, new ListNode(0),1);
    }
}
