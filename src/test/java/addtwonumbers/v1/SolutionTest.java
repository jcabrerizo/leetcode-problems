package addtwonumbers.v1;

import addtwonumbers.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sol = new Solution();

    @Test
    void getIntZeroTest(){
        assertEquals(0, sol.toNumber(new ListNode(0)));
    }

    @Test
    void getIntOneDigicTest(){
        assertEquals(1, sol.toNumber(new ListNode(1)));
    }

    @Test
    void getIntThreeDigits(){
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        assertEquals(321, sol.toNumber(l1));
    }

    @Test
    void toZeroOneDigit(){
        final ListNode l = sol.toList(0);
        assertEquals(l.val, 0);
        assertNull(l.next);
    }

    @Test
    void toListOneDigit(){
        final ListNode l = sol.toList(1);
        assertEquals(l.val, 1);
        assertNull(l.next);
    }

    @Test
    void toListThreeDigits(){
        final ListNode l = sol.toList(321);
        assertEquals(1, l.val);
        assertNotNull(l.next);
        assertEquals( 2,l.next.val);
        assertNotNull(l.next.next);
        assertEquals(3, l.next.next.val);
        assertNull(l.next.next.next);
    }

    @Test
    void sumTest(){
        final ListNode listNode = sol.addTwoNumbers(sol.toList(9), sol.toList(999_999_1));
        assertEquals(10_000_000, sol.toNumber(listNode));
    }

    @Test
    void sumHugeTest(){
        final ListNode listNode = sol.addTwoNumbers(sol.toList(9), sol.toList(999_999_999_1L));
        assertEquals(10_000_000_000L, sol.toNumber(listNode));
    }

    @Test
    void sumWithZeroTest(){
        final ListNode listNode = sol.addTwoNumbers(sol.toList(1001), sol.toList(20));
        assertEquals(1021L, sol.toNumber(listNode));
    }
}