package neetcode.blind75;

public class ReversedLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode current;
        ListNode prev;
        ListNode next;

        if(head==null)
            return null;

        current=head;
        prev = null;
        while(current !=null){
            next = current.next;
            current.next =prev;
            prev=current;
            current=next;

        }
        head = prev;
        return head;
    }
}
