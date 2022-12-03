package com.kp.aoc.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharUtilsTest {

    @Test
    void should_returnUniqueCharacterSet_when_inputPassed() {
        assertEquals(Set.of(), CharUtils.set(null));
        assertEquals(Set.of(), CharUtils.set(""));
        assertEquals(Set.of('H', 'e', 'l', 'o'), CharUtils.set("Hello"));
        assertEquals(Set.of('W', 'o', 'r', 'l', 'd'), CharUtils.set("World"));
        assertEquals(Set.of('!'), CharUtils.set("!!!"));
        assertEquals(Set.of('W', 'w', 'M', 'm'), CharUtils.set("WwMm"));
    }

}