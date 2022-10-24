package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    private final FirstBadVersion firstBadVersion = new FirstBadVersion();

    @Test
    void firstBadVersion() {
        firstBadVersion.setBadVersion(4);
        assertEquals(4 ,firstBadVersion.firstBadVersion(10));
    }

    @Test
    void firstBadVersion2() {
        firstBadVersion.setBadVersion(1);
        assertEquals(1 ,firstBadVersion.firstBadVersion(1));
    }

    @Test
    void firstBadVersion3() {
        firstBadVersion.setBadVersion(2);
        assertEquals(2 ,firstBadVersion.firstBadVersion(2));
    }

    @Test
    void firstBadVersion4() {
        firstBadVersion.setBadVersion(1702766719);
        assertEquals(1702766719 ,firstBadVersion.firstBadVersion(2126753390));
    }
}