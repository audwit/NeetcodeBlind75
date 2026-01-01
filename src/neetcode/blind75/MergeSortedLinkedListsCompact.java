package neetcode.blind75;

import neetcode.blind75.HelperClasses.ListNode;

public class MergeSortedLinkedListsCompact {
    public static void main(String[] args) {
        ListNode list1 = new ListNode();

        ListNode list2 = new ListNode(Integer.MIN_VALUE);
        list2.add(1);
        list2.add(2);

        ListNode result;

        MergeSortedLinkedListsCompact mergeSortedLinkedListsCompact = new MergeSortedLinkedListsCompact();
        result = mergeSortedLinkedListsCompact.mergeTwoLists(list1, list2);

        while(result!=null){
            System.out.println(result.val + "\n");
            result = result.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode ptr = new ListNode(Integer.MIN_VALUE);
        ListNode result = ptr;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                ptr.next = list1;
                ptr=ptr.next;
                list1=list1.next;
            }
            else {
                ptr.next=list2;
                ptr=ptr.next;
                list2=list2.next;
            }


        }

        if(list1==null){
            ptr=list2;
        }

        if(list2==null){
            ptr=list1;
        }
        return result.next;
    }
}
