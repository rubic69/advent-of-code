package com.kp.aoc.year22.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplyStacksTest {

    private SupplyStacks solver;

    @BeforeEach
    void setUp() {
        solver = new SupplyStacks();
    }

    @Test
    void test_part_1_input_sample() throws IOException {
        List<String> input = readInput("sample");
        assertEquals("CMZ", solver.solvePartOne(input));
    }

    @Test
    void test_part_1_input() throws IOException {
        List<String> input = readInput("input");
        assertEquals("VGBBJCRMN", solver.solvePartOne(input));
    }

    @Test
    void test_part_2_input_sample() throws IOException {
        List<String> input = readInput("sample");
        assertEquals("MCD", solver.solvePartTwo(input));
    }

    @Test
    void test_part_2_input() throws IOException {
        List<String> input = readInput("input");
        assertEquals("LBBVJBRMH", solver.solvePartTwo(input));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day05/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }
}