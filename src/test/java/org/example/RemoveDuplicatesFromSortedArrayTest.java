package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {
    private final RemoveDuplicatesFromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesFromSortedArray();

    @Test
    public void testRemoveDuplicates() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int rez = removeDuplicatesfromSortedArray.removeDuplicates(nums);
        assertEquals(5, rez);
        Assertions.assertArrayEquals(new int[]{0,1,2,3,4}, Arrays.copyOf(nums, rez));
    }
}