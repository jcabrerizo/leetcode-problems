package addtwonumbers.v1;

import addtwonumbers.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long ope1 = toNumber(l1);
        long ope2 = toNumber(l2);
        return toList(ope1 + ope2);
    }

    protected ListNode toList(long number) {
        if (number < 10) {
            return new ListNode((int) number);
        }
        return new ListNode((int) (number%10), toList(number/10));
    }

    protected long toNumber(ListNode l) {
        long value = l.val;
        long pos = 1;
        while (l.next != null) {
            l = l.next;
            value += l.val * (Math.pow(10, pos++));
        }
        return value;
    }
}