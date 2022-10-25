package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void testMergeTwoLists() {
        MergeTwoSortedLists.ListNode listNode1 = new MergeTwoSortedLists.ListNode(1, null);
        MergeTwoSortedLists.ListNode listNode2 = new MergeTwoSortedLists.ListNode(1, null);
        MergeTwoSortedLists.ListNode listNode = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);
        int i = 1;
    }
}