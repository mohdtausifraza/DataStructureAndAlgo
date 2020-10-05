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

    public static ListNode createLikedList(int[] arr){
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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode list = createLikedList(arr);
        display(list);
        displayRecursively(list);
        System.out.println(length(list));
        System.out.println(sumOfAllElements(list));
        System.out.println(findMax(list));
        System.out.println(search(list,9));
        display(moveToHead(list,4));
    }
}
