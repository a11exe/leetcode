package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void setBinarySearch1() {
        assertEquals(4, binarySearch.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    @Test
    void setBinarySearch2() {
        assertEquals(-1, binarySearch.search(new int[]{-1,0,3,5,9,12}, 2));
    }

}