package neetcode.blind75.HelperClasses;

import neetcode.blind75.ReversedLinkedList;

public class ListNode {
//    public ListNode head;
//    public ListNode tail;
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void add(int val){
        if(this.val == Integer.MIN_VALUE){
//            ListNode newListNode = new ListNode(Integer.MIN_VALUE);
            this.val = val;
//            tail=head;
        }
        else {
              ListNode current = this;
              while(current.next != null){
                  current=current.next;
              }

              ListNode temp = new ListNode(val);
              temp.next = null;
              current.next=temp;
        }
    }
}
