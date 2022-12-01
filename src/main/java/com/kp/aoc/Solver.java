package com.kp.aoc;

public interface Solver<I, O> {

    default O solvePartOne(I input) {
        throw new UnsupportedOperationException("Solver for Part One called without implementing solution");
    }

    default O solvePartTwo(I input) {
        throw new UnsupportedOperationException("Solver for Part Two called without implementing solution");
    }

}
