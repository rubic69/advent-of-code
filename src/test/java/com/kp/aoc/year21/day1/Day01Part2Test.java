package com.kp.aoc.year21.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Part2Test {

    private Puzzle<List<Integer>, Integer> puzzle;

    @BeforeEach
    void init() {
        puzzle = new Day01Part2();
    }

    @Test
    void test_input_sample() throws IOException {
        assertEquals(5, puzzle.solve(readInput("part_2_sample")));
    }

    @Test
    void test_input() throws IOException {
        assertEquals(1543, puzzle.solve(readInput("part_2_input")));
    }

    private List<Integer> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/day01/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}