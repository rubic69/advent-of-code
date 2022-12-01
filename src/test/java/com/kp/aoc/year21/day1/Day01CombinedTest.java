package com.kp.aoc.year21.day1;

import com.kp.aoc.Solver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01CombinedTest {

    final int PART_1_GAP = 1;
    final int PART_2_GAP = 3;

    private Solver<Day01Combined.Input, Integer> puzzle;

    @BeforeEach
    void init() {
        puzzle = new Day01Combined();
    }

    @Test
    void test_input_sample() throws IOException {
        List<Integer> depths_1 = readInput("part_1_sample");
        Day01Combined.Input input_1 = new Day01Combined.Input(PART_1_GAP, depths_1);
        assertEquals(7, puzzle.solvePartOne(input_1));

        List<Integer> depths_2 = readInput("part_2_sample");
        Day01Combined.Input input_2 = new Day01Combined.Input(PART_2_GAP, depths_2);
        assertEquals(5, puzzle.solvePartTwo(input_2));
    }

    @Test
    void test_input() throws IOException {
        List<Integer> depths_1 = readInput("part_1_input");
        Day01Combined.Input input_1 = new Day01Combined.Input(PART_1_GAP, depths_1);
        assertEquals(1521, puzzle.solvePartOne(input_1));


        List<Integer> depths_2 = readInput("part_2_input");
        Day01Combined.Input input_2 = new Day01Combined.Input(PART_2_GAP, depths_2);
        assertEquals(1543, puzzle.solvePartTwo(input_2));
    }


    private List<Integer> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/day01/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}