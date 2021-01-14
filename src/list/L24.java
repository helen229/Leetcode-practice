package list;

public class L24 {
    /**
     *    approaches for linked list problems
     *    1. two pointers
     *    2. recursion (iterative also works but this is more elegant)
     *    this is a classic linked list question to solve with recursion
     **/
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);;
        temp.next=head;
        return temp;
    }
}
