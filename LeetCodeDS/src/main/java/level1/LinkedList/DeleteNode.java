/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/553/
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 *
 *  Input: head = [4,5,1,9], node = 5
 *  Output: [4,1,9]
 *  Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Approach :   Traverse from the node and swap the value with the next node.
 *
 */


package level1.LinkedList;
class DeleteNode {
    public void deleteNode(ListNode node) {
        while(node.next != null){
            node.val=node.next.val;
            if(node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
