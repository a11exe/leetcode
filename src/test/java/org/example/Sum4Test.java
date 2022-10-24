package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Sum4Test {

    private final Sum4 sum4 = new Sum4();

    @Test
    void test1() {
        assertEquals(Arrays.asList(Arrays.asList(-2,-1,1,2),Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1)),
                sum4.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }


}