package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {
    private final RemoveElement removeElement = new RemoveElement();

    @Test
    public void test1() {
        int[] arr = {1, 3, 1, 4, 1};
        int k = removeElement.removeElement(arr, 1);
        assertEquals(2, k);
        Assertions.assertArrayEquals(new int[]{3,4}, Arrays.copyOf(arr, k));

    }
}