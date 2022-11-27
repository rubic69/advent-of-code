package com.kp.puzzles;

public interface Puzzle<I, O> {

    O solve(I input);

}
