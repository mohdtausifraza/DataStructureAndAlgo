package LinkedList;

/**
 * LinkedList is a collection of Nodes where each nodes contains data and reference to next node.
 */
public class LinkedList {
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value, ListNode next){
            this.value = value;
            this.next=next;
        }
    }

    public static ListNode createLikedListFromArray(int[] arr){
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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode list = createLikedListFromArray(arr);
        display(list);
        displayRecursively(list);
        System.out.println(length(list));
        System.out.println(sumOfAllElements(list));
        System.out.println(findMax(list));
        System.out.println(search(list,9));
        list = moveToHead(list,4);
        display(list);
        list = insertBeforeFirst(list , new ListNode(0,null));
        display(list);
        list = insertAfterPos(list , new ListNode(-1,null),5);
        display(list);
        ListNode insertAtLast = insertAtLast(null , new ListNode(11,null));
        insertAtLast = insertAtLast(insertAtLast , new ListNode(22,null));
        display(insertAtLast);
        int[] arr2 = {1,3,4,5,6,7,8,9};
        ListNode sortedList = createLikedListFromArray(arr2);
        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(0,null));
        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(2,null));
        sortedList = insertIntoSortedLinkedList(sortedList , new ListNode(22,null));
        display(sortedList);
    }
}
