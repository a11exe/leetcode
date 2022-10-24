package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    private final SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    void setBinarySearch1() {
        assertEquals(2, searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    void setBinarySearch2() {
        assertEquals(1, searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    void setBinarySearch3() {
        assertEquals(4, searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    void setBinarySearch4() {
        assertEquals(0, searchInsertPosition.searchInsert(new int[]{1}, 1));
    }

}