package addtwonumbers.v2;


import addtwonumbers.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int nodesSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
        if (nodesSum > 9) {
            addOne(l1);
            nodesSum = nodesSum % 10;
        }

        return new ListNode(nodesSum, addTwoNumbers(l1!=null?l1.next:new ListNode(0), l2!=null?l2.next:new ListNode(0)));
    }

    private void addOne(ListNode l1) {
        if(l1.next==null){
            l1.next = new ListNode(1);
        }else{
            l1.next.val= l1.next.val+1;
            if (l1.next.val > 9) {
                l1.next.val = l1.next.val % 10;
                addOne(l1.next);
            }
        }
    }
}