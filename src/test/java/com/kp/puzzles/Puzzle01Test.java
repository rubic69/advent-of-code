package com.kp.puzzles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle01Test {

    private Puzzle<Object, Object> puzzle;

    @BeforeEach
    void init() {
        puzzle = new Puzzle01();
    }

    @Test
    void test() {
        assertNotNull(puzzle.solve(null));
    }

}