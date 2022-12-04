package com.kp.aoc.year22.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampCleanupTest {

    private CampCleanup solver;

    @BeforeEach
    void setUp() {
        solver = new CampCleanup();
    }

    @Test
    void test_part_1_individualExamples() {
        assertEquals(1, solver.solvePartOne(List.of("1-1,1-1")));
        assertEquals(1, solver.solvePartOne(List.of("1-2,1-1")));
        assertEquals(1, solver.solvePartOne(List.of("1-1,1-2")));
        assertEquals(0, solver.solvePartOne(List.of("1-1,2-3")));

        assertEquals(0, solver.solvePartOne(List.of("2-4,6-8")));
        assertEquals(0, solver.solvePartOne(List.of("2-3,4-5")));
        assertEquals(0, solver.solvePartOne(List.of("5-7,7-9")));
        assertEquals(1, solver.solvePartOne(List.of("2-8,3-7")));
        assertEquals(1, solver.solvePartOne(List.of("6-6,4-6")));
        assertEquals(0, solver.solvePartOne(List.of("2-6,4-8")));
    }

    @Test
    void test_part_1_input_sample() throws IOException {
        List<String> input = readInput("sample");
        assertEquals(2, solver.solvePartOne(input));
    }

    @Test
    void test_part_1_input() throws IOException {
        List<String> input = readInput("input");
        assertEquals(538, solver.solvePartOne(input));
    }

    private List<String> readInput(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/year22/day04/%s.txt".formatted(fileName));
        return Files.readAllLines(path);
    }
}