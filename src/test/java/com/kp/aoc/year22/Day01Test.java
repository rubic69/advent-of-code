package com.kp.aoc.year22;

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

class Day01Test {

    public static final int TOP_RECORDS_AMOUNT_PART_1 = 1;
    public static final int TOP_RECORDS_AMOUNT_PART_2 = 3;
    private Solver<Day01.Input, Integer> solver;

    @BeforeEach
    void init() {
        solver = new Day01();
    }

    @Test
    void test_part_1_input_sample() throws IOException {
        List<Integer> input = readInput("part_1_sample");
        assertEquals(24000, solver.solvePartOne(new Day01.Input(TOP_RECORDS_AMOUNT_PART_1, input)));
    }

    @Test
    void test_part_1_input() throws IOException {
        List<Integer> input = readInput("part_1_input");
        assertEquals(72718, solver.solvePartOne(new Day01.Input(TOP_RECORDS_AMOUNT_PART_1, input)));
    }

    @Test
    void test_part_2_input_sample() throws IOException {
        List<Integer> input = readInput("part_1_sample");
        assertEquals(45000, solver.solvePartTwo(new Day01.Input(TOP_RECORDS_AMOUNT_PART_2, input)));
    }

    @Test
    void test_part_2_input() throws IOException {
        List<Integer> input = readInput("part_2_input");
        assertEquals(213089, solver.solvePartTwo(new Day01.Input(TOP_RECORDS_AMOUNT_PART_2, input)));
    }

    private List<Integer> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day01/%s.txt".formatted(fileName));
        List<String> allLines = Files.readAllLines(path);
        return allLines.stream()
                .map(line -> !line.isBlank() ? Integer.valueOf(line) : null)
                .collect(Collectors.toList());
    }

}