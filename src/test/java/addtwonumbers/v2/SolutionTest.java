package addtwonumbers.v2;

import addtwonumbers.ListNode;
import addtwonumbers.v1.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    addtwonumbers.v1.Solution sol = new Solution();

    @Test
    void sumTest(){
        final ListNode listNode = sol.addTwoNumbers(new ListNode(1), new ListNode(2));
        assertEquals(3, listNode.val);
    }
}