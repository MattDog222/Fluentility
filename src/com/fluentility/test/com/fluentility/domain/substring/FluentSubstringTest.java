package com.fluentility.domain.substring;

import org.junit.jupiter.api.Test;

import static com.fluentility.domain.substring.FluentSubstring.fluentSubstring;
import static org.junit.jupiter.api.Assertions.*;

class FluentSubstringTest {

    private final String TEST = "abcdefghijklmnopqrstuvwxyz";

    @Test
    public void onlyTo() {
        assertEquals(fluentSubstring().of(TEST).to(1).get(), "");
        assertEquals(fluentSubstring().of(TEST).to(1).get(), "a");
        assertEquals(fluentSubstring().of(TEST).to(2).get(), "ab");
        assertEquals(fluentSubstring().of(TEST).to(3).get(), "abc");
        assertEquals(fluentSubstring().of(TEST).to(-1).get(), "abcdefghijklmnopqrstuvwxy");
        assertEquals(fluentSubstring().of(TEST).to(-2).get(), "abcdefghijklmnopqrstuvwx");
        assertEquals(fluentSubstring().of(TEST).to(-3).get(), "abcdefghijklmnopqrstuvw");
    }

    @Test
    public void onlyToInclusive() {
        assertEquals(fluentSubstring().of(TEST).toInclusive(0).get(), "a");
        assertEquals(fluentSubstring().of(TEST).toInclusive(1).get(), "ab");
        assertEquals(fluentSubstring().of(TEST).toInclusive(2).get(), "abc");
        assertEquals(fluentSubstring().of(TEST).toInclusive(3).get(), "abcd");
        assertEquals(fluentSubstring().of(TEST).toInclusive(-1).get(), "abcdefghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).toInclusive(-2).get(), "abcdefghijklmnopqrstuvwxy");
        assertEquals(fluentSubstring().of(TEST).toInclusive(-3).get(), "abcdefghijklmnopqrstuvwx");
    }

    @Test
    public void onlyFromExclusive() {
        assertEquals(fluentSubstring().of(TEST).fromExclusive(0).get(), "bcdefghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(1).get(), "cdefghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(2).get(), "defghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(3).get(), "efghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-1).get(), "");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-2).get(), "z");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-3).get(), "yz");
    }

    @Test
    public void onlyFrom() {
        assertEquals(fluentSubstring().of(TEST).fromExclusive(0).get(), TEST);
        assertEquals(fluentSubstring().of(TEST).fromExclusive(1).get(), "bcdefghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(2).get(), "cdefghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(3).get(), "defghijklmnopqrstuvwxyz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-1).get(), "z");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-2).get(), "yz");
        assertEquals(fluentSubstring().of(TEST).fromExclusive(-3).get(), "xyz");
    }

    @Test
    public void fromToEqual() {
        for (int i = -26; i < 26; ++i) {
            assertTrue(fluentSubstring().of(TEST).from(i).to(i).get().isEmpty());
        }
    }

    @Test
    public void fromToLength1() {
        for (int i = -25; i <= 25; ++i) {
            assertEquals(fluentSubstring().of(TEST).from(i).to(i+1).get().length(), 1);

        }
    }
}