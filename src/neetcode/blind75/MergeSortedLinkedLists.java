package neetcode.blind75;

import neetcode.blind75.HelperClasses.ListNode;

public class MergeSortedLinkedLists {


    public static void main(String[] args) {

        ListNode list1 = new ListNode(Integer.MIN_VALUE);
//        list1.add(1);
//        list1.add(2);
//        list1.add(4);
        list1.add(2);

        ListNode list2 = new ListNode(Integer.MIN_VALUE);
//        list2.add(1);
//        list2.add(3);
//        list2.add(5);

        list2.add(1);
//        list2.add(2);

        MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();
        ListNode result = mergeSortedLinkedLists.mergeTwoLists(list1, list2);

        while(result!=null){
            System.out.println(result.val + "\n");
            result = result.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode current = result;

        int list1Num=0;
        int list2Num=0;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        if(list1==null && list2==null)
            return null;

        if(list1!=null){
            while(temp1 != null){
                list1Num++;
                temp1 = temp1.next;
            }
        }

        if(list2!=null){
            while(temp2 != null){
                list2Num++;
                temp2 = temp2.next;
            }
        }



        while(list1Num>0 && list2Num>0){
            if(list1.val<list2.val){
                ListNode newNode = new ListNode(list1.val);// This line can be taken outside and reused
                current.next = newNode;
                list1 = list1.next;
                list1Num--;
                current=current.next;
            }
            else if(list2.val<list1.val){
                if(current.val!=Integer.MIN_VALUE){
                    ListNode newNode = new ListNode(list2.val);
                    current.next = newNode;
                }
                else
                    current.val = list2.val;
                list2=list2.next;
                list2Num--;
            }
            else{
                if(current.val!=Integer.MIN_VALUE){
                    ListNode newNode1 = new ListNode(list1.val);
                    current.next= newNode1;
                    list1=list1.next;
                    current = current.next;
                }
//                current=current.next;
                else{
                    current.val = list1.val;
                    list1=list1.next;
                }

                ListNode newNode2 = new ListNode(list2.val);
                current.next = newNode2;
                list2=list2.next;

                current=current.next;
                list1Num--;
                list2Num--;
            }
        }

        while(list1Num>0){
            if(current.val!=Integer.MIN_VALUE){
                ListNode newNode4 = new ListNode(list1.val);
                current.next=newNode4;
                current=current.next;
            }
            else
                current.val = list1.val;
            list1=list1.next;
            list1Num--;
        }

        while(list2Num>0){
            if(current.val!=Integer.MIN_VALUE){
                ListNode newNode3 = new ListNode(list2.val);
                current.next=newNode3;
                current=current.next;
            }
            else
                current.val = list2.val;
            list2=list2.next;
            list2Num--;
        }

//        current=null;
        return result;
    }
}
