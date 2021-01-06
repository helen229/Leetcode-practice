package dailychallenge;

public class Jan5 {
    /** LinkList question */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevNode = new ListNode(101, head);
        //why I must have a dummy node to return ??? [1,1,1,3,5] failed if not
        ListNode res = prevNode;
        ListNode curNode = head;
        while(curNode != null){
            while(curNode.next!= null && curNode.next.val == curNode.val){
                curNode = curNode.next;
            }

            if(prevNode.next != curNode){
                prevNode.next = curNode.next;
                curNode = prevNode.next;
            }else{
                prevNode = prevNode.next;
                curNode = curNode.next;
            }
        }
        return res.next;
    }
}
