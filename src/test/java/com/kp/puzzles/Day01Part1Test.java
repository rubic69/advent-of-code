package com.kp.puzzles;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class Day01Part1Test {

    private Puzzle<List<Integer>, Integer> puzzle;

    @BeforeEach
    void init() {
        puzzle = new Day01Part1();
    }

    @Test
    void test_input_sample() throws IOException {
        assertEquals(7, puzzle.solve(readInput("part_1_sample")));
    }

    @Test
    void test_input() throws IOException {
        assertEquals(1521, puzzle.solve(readInput("part_1_input")));
    }

    private List<Integer> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/day01/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}