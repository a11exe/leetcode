package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    private final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    void test1() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode ll1 = l1;
        for (int i = 0; i < 6; i++) {
            ll1.next = new AddTwoNumbers.ListNode(9);
            ll1 = ll1.next;
        }
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l22 = l2;
        for (int i = 0; i < 3; i++) {
            l22.next = new AddTwoNumbers.ListNode(9);
            l22 = l22.next;
        }
                
        addTwoNumbers.addTwoNumbers(l1, l2);
    }
}