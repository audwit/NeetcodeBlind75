package neetcode.blind75;

import neetcode.blind75.HelperClasses.ListNode;

import java.util.HashSet;

public class LinkedListCycleDetection {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        HashSet<String> addresses = new HashSet<>();
        ListNode current = head;
        System.out.println(current.next);

        while(current!=null && current.next!=null){
            if(!addresses.contains(current.next.toString())){
                addresses.add(current.next.toString());
                current=current.next;
            }
            else
                return true;
        }
        return false;
    }

    // Cycle detection with a fast ponter and a slow pointer

//    public boolean hasCycle(ListNode head) {
//        ListNode slowPtr = head;
//        ListNode fastPtr = head;
//
//        while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null){
//            slowPtr=slowPtr.next;
//            fastPtr=fastPtr.next.next;
//
//            if(slowPtr==fastPtr)
//                return true;
//        }
//        return false;
//    }
}
